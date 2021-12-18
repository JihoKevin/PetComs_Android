package kevin.android.petcoms.fragments.record

import android.view.View
import android.view.ViewConfiguration
import android.widget.TextView
import com.kizitonwose.calendarview.model.CalendarDay
import com.kizitonwose.calendarview.model.DayOwner
import com.kizitonwose.calendarview.ui.ViewContainer
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.CalendarDayLayoutBinding

class CalendarViewContainer(view: View) : ViewContainer(view) {

    val textView = CalendarDayLayoutBinding.bind(view).calendarDayText



}

