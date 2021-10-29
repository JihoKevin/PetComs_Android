package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyFamilyBinding
import kevin.android.petcoms.fragments.mypage.model.TestModel

class MyFamAdapter(private var data: List<TestModel>): RecyclerView.Adapter<MyFamAdapter.MyFamViewHolder>() {

    class MyFamViewHolder(val binding: ListMyFamilyBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: TestModel) {
            binding.testModel = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFamViewHolder {
        val binding = ListMyFamilyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyFamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyFamViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}