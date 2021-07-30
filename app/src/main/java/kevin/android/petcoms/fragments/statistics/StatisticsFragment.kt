package kevin.android.petcoms.fragments.statistics

import android.graphics.Color
import android.os.Bundle
import android.os.DropBoxManager
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentStatisticsBinding
import kevin.android.petcoms.fragments.statistics.viewmodel.StatisticsViewModel

class StatisticsFragment : Fragment() {

    private lateinit var pieChart: PieChart
//    lateinit var statisticsViewModel: StatisticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//         Inflate the layout for this fragment
//        val view = inflater.inflate(R.layout.fragment_statistics, container, false)

        val binding = FragmentStatisticsBinding.inflate(inflater, container, false)

//        pieChart = view.findViewById(R.id.pieChart)
        pieChart = binding.pieChart

        initPieChart()

        setDataToPieChart()

//        statisticsViewModel = ViewModelProvider(this).get(StatisticsViewModel::class.java)
//        statisticsViewModel.currentValue.observe(this, Observer {
//            it
//        })


//        return view
        return binding.root
    }

    private fun initPieChart() {
        pieChart.setUsePercentValues(true)
        pieChart.description.text = "" // 아래에 그래프 제목 표시
        //hollow pie chart
        pieChart.isDrawHoleEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setDrawEntryLabels(false)
        //adding padding
        pieChart.setExtraOffsets(20f, 0f, 20f, 20f)
        pieChart.setUsePercentValues(true)
        pieChart.isRotationEnabled = false // 드래그를 통해 회전판처럼 돌리는 기능
        pieChart.setDrawEntryLabels(false)
        pieChart.legend.orientation = Legend.LegendOrientation.VERTICAL
        pieChart.legend.isWordWrapEnabled = true

    }

    private fun setDataToPieChart() {
        pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>() // 임의 데이터
        dataEntries.add(PieEntry(72f, "산책"))
        dataEntries.add(PieEntry(26f, "목욕"))
        dataEntries.add(PieEntry(2f, "병원"))

        val colors: ArrayList<Int> = ArrayList() // 원형 그래프 색상
        colors.add(Color.parseColor("#4DD0E1"))
        colors.add(Color.parseColor("#FFF176"))
        colors.add(Color.parseColor("#FF8A65"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // 퍼센테이지
        data.setValueFormatter(PercentFormatter())
        dataSet.sliceSpace = 3f
        dataSet.colors = colors
        pieChart.data = data
        data.setValueTextSize(15f)
        pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //가운데 빈원형 설정
        pieChart.holeRadius = 58f
        pieChart.transparentCircleRadius = 61f
        pieChart.isDrawHoleEnabled = true // false -> 피자처럼 중간에 빈원형없이 가득찬 Pie
        pieChart.setHoleColor(Color.WHITE)


        //원형 그래프 hollow에 제목 넣기(반려견 이름)
        pieChart.setDrawCenterText(true);
        pieChart.centerText = "땅콩이"



        pieChart.invalidate()

    }


}