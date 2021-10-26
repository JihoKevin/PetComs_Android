package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyFamilyBinding
import kevin.android.petcoms.fragments.mypage.model.MyFamily

class MyFamAdapter(): RecyclerView.Adapter<MyFamAdapter.MyFamViewHolder>() {

    var myFamList = mutableListOf<MyFamily>()

    class MyFamViewHolder(val binding: ListMyFamilyBinding) : RecyclerView.ViewHolder(binding.root) {
//        val myFamImg = itemView.findViewById<ImageView>(R.id.img_family)
//        val myFamName = itemView.findViewById<TextView>(R.id.family_name)
        fun bind(currentMyFamily: MyFamily) {
            binding.myFamily = currentMyFamily
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFamAdapter.MyFamViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_my_family, parent, false)
//        return MyFamViewHolder(view)
        val binding = ListMyFamilyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyFamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyFamAdapter.MyFamViewHolder, position: Int) {
//        holder.myFamImg.setImageResource(myFamList.get(position).myFamImg)
//        holder.myFamName.text = myFamList.get(position).myFamName
        holder.bind(myFamList[position])
    }

    override fun getItemCount(): Int {
        return myFamList.size
    }

    fun setData(data : ArrayList<MyFamily>){
        myFamList = data
        notifyDataSetChanged()
    }

}