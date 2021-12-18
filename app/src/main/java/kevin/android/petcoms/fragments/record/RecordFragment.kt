package kevin.android.petcoms.fragments.record

import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.ui.DayBinder
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentRecordBinding
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel
import kotlinx.android.synthetic.main.fragment_record.*
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

@AndroidEntryPoint
class RecordFragment : PetComsBaseFragment<FragmentRecordBinding>(R.layout.fragment_record) {

    private val viewModel: RecordViewModel by activityViewModels()

    override fun initViews(view: View) {
        binding.txtTest.setOnClickListener {
            viewModel.getComments(2)
        }

        calendarView.dayBinder = object : DayBinder<CalendarViewContainer> {
            override fun bind(container: CalendarViewContainer, day: CalendarDay) {
                container.textView.text = day.date.dayOfMonth.toString()
            }
            override fun create(view: View): CalendarViewContainer =
                CalendarViewContainer(view)

        }
        val currentMonth = YearMonth.now()
        val firstMonth = currentMonth.minusMonths(10)
        val lastMonth = currentMonth.plusMonths(10)
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        calendarView.setup(firstMonth, lastMonth, firstDayOfWeek)
        calendarView.scrollToMonth(currentMonth)
    }

    override fun observeData() {
        viewModel.comments.observe(viewLifecycleOwner, Observer {
            binding.txtTest.text = it.response.toString()
        })
    }
}



