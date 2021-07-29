package kevin.android.petcoms.fragments.record

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kevin.android.petcoms.R
import kevin.android.petcoms.fragments.record.viewmodel.ActionType
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel
import kevin.android.petcoms.network.Client

/**
 * 2021. 07. 21  AM 01:21
*  MpChart를 이용하여 막대 그래프 그리는 UI 로직 구현 시도.
 *  RecordViewModel의 updateValue 함수의 두 번째 매개변수를 직접 숫자로 입력하여 차트의 값을 변하게 하는 것은 성공 하였으나
 *  editText로 시도 할 시 toFloat() 함수를 인식하지 못하고 NumberFormatException 발생..
**/
class RecordFragment : Fragment(), View.OnClickListener {


    lateinit var recordViewModel: RecordViewModel
//    val editInput = view?.findViewById<EditText>(R.id.editInput)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_record, container, false)

        val btnClick = view.findViewById<Button>(R.id.btnPut)
        val barChart = view.findViewById<BarChart>(R.id.examChart)
        val entries = mutableListOf<BarEntry>()
        entries.add(BarEntry(0f, 4.1f))
        entries.add(BarEntry(1f,5f))
        entries.add(BarEntry(2f,8.4f))
        entries.add(BarEntry(3f,6.0f))
        entries.add(BarEntry(4f,3.2f))

        //위에서 만든 BarEntry 리스트를 인자로 준다
        val barDataSet = BarDataSet(entries, "MyBarDataSet")

        barDataSet.color = ColorTemplate.rgb("#ff7b22")

        val barData = BarData(barDataSet)
        barData.barWidth = 0.3f

        barChart.data = barData
        barChart.animateXY(0, 1500)
        barChart.description = null
        barChart.axisLeft.setDrawGridLines(false)
        barChart.axisRight.setDrawGridLines(false)

        barChart.xAxis.setDrawGridLines(false)
        barChart.xAxis.labelCount = entries.size
        barChart.invalidate()

        recordViewModel = ViewModelProvider(this).get(RecordViewModel::class.java)
        recordViewModel.currentValue.observe(viewLifecycleOwner, Observer {
            entries[0].y = it
            barChart.animateXY(0, 1500)
            barChart.invalidate()
        })

        btnClick.setOnClickListener(this)

        return view
    }

    override fun onClick(view: View?) {

//        var float = editInput?.text.toString()
//
//        if(float == null || float.trim().equals("")){
//            float = "2.0f"
//        }


        recordViewModel.updateValue(actionType = ActionType.CLICK, 8.0f)

    }

}

