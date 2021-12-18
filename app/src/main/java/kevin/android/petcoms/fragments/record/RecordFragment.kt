package kevin.android.petcoms.fragments.record

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import dagger.hilt.android.AndroidEntryPoint
import io.blackbox_vision.materialcalendarview.view.CalendarView
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.CalendarDayLayoutBinding
import kevin.android.petcoms.databinding.FragmentRecordBinding
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel
import kotlinx.android.synthetic.main.fragment_record.*
import java.time.DayOfWeek
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

@AndroidEntryPoint
class RecordFragment : PetComsBaseFragment<FragmentRecordBinding>(R.layout.fragment_record) {

    private val viewModel: RecordViewModel by activityViewModels()
    val currentMonth = YearMonth.now()
    val firstMonth = currentMonth.minusMonths(10)
    val lastMonth = currentMonth.plusMonths(10)
    val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek

    val daysOfWeek = arrayOf(
        DayOfWeek.SUNDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
    )
// Use the daysOfWeek to set up your month header texts:
// Sun | Mon | Tue | Wed | Thu | Fri | Sat



    override fun initViews(view: View) {
        txtTest.setOnClickListener {
            viewModel.getComments(2)
        }

        calendarView.dayBinder = object : DayBinder<DayViewContainer>{
            // 새로운container 필요 시 호출됨
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.textView.text = day.date.dayOfMonth.toString()
                if (day.owner == DayOwner.THIS_MONTH) {
                    container.textView.setTextColor(Color.BLACK)
                } else {
                    container.textView.setTextColor(Color.GRAY)
                }
            }

            // 재사용 용도의 bind
            override fun create(view: View): DayViewContainer = DayViewContainer(view)

        }

        calendarView.monthHeaderBinder = object : MonthHeaderFooterBinder<MonthViewContainer> {
            override fun create(view: View) = MonthViewContainer(view)
            override fun bind(container: MonthViewContainer, month: CalendarMonth) {
                container.textView.text = "${month.yearMonth.month.name} ${month.year}"
            }
        }

        calendarView.setup(firstMonth, lastMonth, daysOfWeek.first())
        calendarView.scrollToMonth(currentMonth)

    }

    override fun observeData() {
        viewModel.comments.observe(viewLifecycleOwner, Observer {
            binding.txtTest.text = it.response.toString()
        })
    }

    inner class DayViewContainer(view: View) : ViewContainer(view) {

        val textView = CalendarDayLayoutBinding.bind(view).calendarDayText


    }

    inner class MonthViewContainer(view: View) : ViewContainer(view) {
        val textView = view.findViewById<TextView>(R.id.headerTextView)
    }



}



