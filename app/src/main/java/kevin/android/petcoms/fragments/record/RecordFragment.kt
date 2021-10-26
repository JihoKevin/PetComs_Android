package kevin.android.petcoms.fragments.record

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.FragmentRecordBinding
import kevin.android.petcoms.fragments.record.adapter.RecordViewPagerAdapter
import kevin.android.petcoms.fragments.record.viewmodel.RecordViewModel

@AndroidEntryPoint
class RecordFragment : Fragment() {

    private var mBinding: FragmentRecordBinding? = null // 뷰 바인딩 활용 (findViewById 사용 할 필요 없음) 접근 방법 : binding.id . . .
    private val binding get() = mBinding!! // 매번 null check 할 필요 없이 바인딩 변수 재 선언

    private val recordViewModel: RecordViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_record, container, false)
        binding.lifecycleOwner = this
        //var repository = RecordRepository()
        //val viewModelFactory = RecordViewModelFactory(repository)

//        recordViewModel = ViewModelProvider(this, viewModelFactory).get(RecordViewModel::class.java)

        attachViewPager()

//        val btnClick = view.findViewById<Button>(R.id.btnPut)
//        val barChart = view.findViewById<BarChart>(R.id.examChart)
//        val entries = mutableListOf<BarEntry>()
//        entries.add(BarEntry(0f, 4.1f))
//        entries.add(BarEntry(1f,5f))
//        entries.add(BarEntry(2f,8.4f))
//        entries.add(BarEntry(3f,6.0f))
//        entries.add(BarEntry(4f,3.2f))
//
//        //위에서 만든 BarEntry 리스트를 인자로 준다
//        val barDataSet = BarDataSet(entries, "MyBarDataSet")
//
//        barDataSet.color = ColorTemplate.rgb("#ff7b22")
//
//        val barData = BarData(barDataSet)
//        barData.barWidth = 0.3f
//
//        barChart.data = barData
//        barChart.animateXY(0, 1500)
//        barChart.description = null
//        barChart.axisLeft.setDrawGridLines(false)
//        barChart.axisRight.setDrawGridLines(false)
//
//        barChart.xAxis.setDrawGridLines(false)
//        barChart.xAxis.labelCount = entries.size
//        barChart.invalidate()
//
//        recordViewModel = ViewModelProvider(this).get(RecordViewModel::class.java)
//        recordViewModel.currentValue.observe(viewLifecycleOwner, Observer {
//            entries[0].y = it
//            barChart.animateXY(0, 1500)
//            barChart.invalidate()
//        })
//
//        btnClick.setOnClickListener(this)

        return binding.root
    }

    private fun attachViewPager() {
        val viewPagerAdapter = RecordViewPagerAdapter(requireFragmentManager(), lifecycle)
        binding.recordViewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.recordTabLayout, binding.recordViewPager){
                tab, position ->
            when(position){
                0 -> tab.text = "최신순"
                1 -> tab.text = "인기순"
            }
        }.attach()
    }

//    override fun onClick(view: View?) {

//        var float = editInput?.text.toString()
//
//        if(float == null || float.trim().equals("")){
//            float = "2.0f"
//        }


//        recordViewModel.updateValue(actionType = ActionType.CLICK, 8.0f)

}



