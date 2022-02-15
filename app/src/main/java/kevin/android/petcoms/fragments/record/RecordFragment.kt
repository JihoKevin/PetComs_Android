package kevin.android.petcoms.fragments.record

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.CalendarMonth
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.model.InDateStyle
import com.kizitonwose.calendarview.ui.DayBinder
import com.kizitonwose.calendarview.ui.MonthHeaderFooterBinder
import com.kizitonwose.calendarview.ui.ViewContainer
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.CalendarDayLayoutBinding
import kevin.android.petcoms.databinding.FragmentRecordBinding
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel
import kotlinx.android.synthetic.main.fragment_record.*
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.time.temporal.WeekFields
import java.util.*

@AndroidEntryPoint
class RecordFragment : PetComsBaseFragment<FragmentRecordBinding>(R.layout.fragment_record) {

    private val viewModel: RecordViewModel by activityViewModels()
    private val currentMonth: YearMonth = YearMonth.now()
    private val firstMonth = currentMonth.minusMonths(10)
    private val lastMonth = currentMonth.plusMonths(10)
    private val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
    private var selectedDate: LocalDate? = null

    val daysOfWeek = arrayOf(
        DayOfWeek.SUNDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY,
        DayOfWeek.SATURDAY
    )

    override fun initViews(view: View) {

        calendarView.dayBinder = object : DayBinder<DayViewContainer> {
            override fun create(view: View) = DayViewContainer(view)
            override fun bind(container: DayViewContainer, day: CalendarDay) {
                container.day = day
                val textView = container.textView
                textView.text = day.date.dayOfMonth.toString()
                if (day.owner == DayOwner.THIS_MONTH) {
                    // Show the month dates. Remember that views are recycled!
                    textView.visibility = View.VISIBLE
                    if (day.date == selectedDate) {
                        // If this is the selected date, show a round background and change the text color.
                        textView.setTextColor(Color.WHITE)
                        textView.setBackgroundResource(R.drawable.ic_select)

                    } else {
                        // If this is NOT the selected date, remove the background and reset the text color.
                        textView.setTextColor(Color.BLACK)
                        textView.background = null
                    }
                } else {
                    // Hide in and out dates
                    textView.setTextColor(Color.GRAY)
                }
            }
        }


        calendarView.monthHeaderBinder = object : MonthHeaderFooterBinder<MonthViewContainer> {
            override fun create(view: View) = MonthViewContainer(view)
            override fun bind(container: MonthViewContainer, month: CalendarMonth) {

                when (month.yearMonth.month.name) {
                    "JANUARY" -> container.textView.text = "${month.year}년 1월"
                    "FEBRUARY" -> container.textView.text = "${month.year}년 2월"
                    "MARCH" -> container.textView.text = "${month.year}년 3월"
                    "APRIL" -> container.textView.text = "${month.year}년 4월"
                    "MAY" -> container.textView.text = "${month.year}년 5월"
                    "JUNE" -> container.textView.text = "${month.year}년 6월"
                    "JULY" -> container.textView.text = "${month.year}년 7월"
                    "AUGUST" -> container.textView.text = "${month.year}년 8월"
                    "SEPTEMBER" -> container.textView.text = "${month.year}년 9월"
                    "OCTOBER" -> container.textView.text = "${month.year}년 10월"
                    "NOVEMBER" -> container.textView.text = "${month.year}년 11월"
                    "DECEMBER" -> container.textView.text = "${month.year}년 12월"
                }
            }
        }

        calendarView.setup(firstMonth, lastMonth, daysOfWeek.first())
        // calendarView.scrollToMonth(currentMonth)
        calendarView.scrollToDate(LocalDate.now())

    }

    /** 주 단위 모드 함수 **/
    private fun setWeekMode() {
        calendarView.updateMonthConfiguration(
            inDateStyle = InDateStyle.ALL_MONTHS,
            maxRowCount = 1,
            hasBoundaries = true
        )
    }

    /** 월 단위 모드 함수 **/
    private fun setMonthlyMode() {
        calendarView.updateMonthConfiguration(
            inDateStyle = InDateStyle.FIRST_MONTH,
            maxRowCount = 6,
            hasBoundaries = true
        )
    }

    inner class DayViewContainer(view: View) : ViewContainer(view) {

        val textView = CalendarDayLayoutBinding.bind(view).calendarDayText
        lateinit var day: CalendarDay
        val thisDayOwner = DayOwner.THIS_MONTH
        val previousDayOwner = DayOwner.PREVIOUS_MONTH
        val nextDayOwner = DayOwner.NEXT_MONTH


        init {
            view.setOnClickListener {
                val currentSelection = selectedDate
                /** 각 날짜가 클릭되었을 때 실행되는 Click Listener **/
                if (day.owner == thisDayOwner) {
                    // Keep a reference to any previous selection
                    // in case we overwrite it and need to reload it.

                    if (currentSelection == day.date) {
                        // If the user clicks the same date, clear selection.
                        selectedDate = null
                        // Reload this date so the dayBinder is called
                        // and we can REMOVE the selection background.
                        calendarView.notifyDateChanged(currentSelection)
                    } else {
                        selectedDate = day.date
                        // Reload the newly selected date so the dayBinder is
                        // called and we can ADD the selection background.
                        calendarView.notifyDateChanged(day.date)
                        if (currentSelection != null) {
                            // We need to also reload the previously selected
                            // date so we can REMOVE the selection background.
                            calendarView.notifyDateChanged(currentSelection)
                        }
                    }
                }

            }
        }

        private fun fetchCalendarRecord() {

        }
    }

    inner class MonthViewContainer(view: View) : ViewContainer(view) {
        val textView = view.findViewById<TextView>(R.id.headerTextView)
    }

    private fun daysOfWeekFromLocale(): Array<DayOfWeek> {
        val firstDayOfWeek = WeekFields.of(Locale.getDefault()).firstDayOfWeek
        val daysOfWeek = DayOfWeek.values()
        // Order `daysOfWeek` array so that firstDayOfWeek is at index 0.
        // Only necessary if firstDayOfWeek is not DayOfWeek.MONDAY which has ordinal 0.
        if (firstDayOfWeek != DayOfWeek.MONDAY) {
            val rhs = daysOfWeek.sliceArray(firstDayOfWeek.ordinal..daysOfWeek.indices.last)
            val lhs = daysOfWeek.sliceArray(0 until firstDayOfWeek.ordinal)
            return rhs + lhs
        }
        return daysOfWeek
    }


}



