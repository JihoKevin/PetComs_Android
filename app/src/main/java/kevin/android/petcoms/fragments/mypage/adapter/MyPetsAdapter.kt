package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListMyPetsBinding
import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.model.TestModel
import kevin.android.petcoms.models.PostModel

class MyPetsAdapter(private var data: List<MyPets>): RecyclerView.Adapter<MyPetsAdapter.MyPetsViewHolder>() {


    class MyPetsViewHolder(val binding: ListMyPetsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: MyPets) {
            binding.item = data
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPetsViewHolder {
        val binding = ListMyPetsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPetsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

//    fun setItem(item: ArrayList<MyPets>){
//        data = item
//        notifyDataSetChanged()
//    }
//    fun setData(data : MutableList<MyPets>){
//        myPetsList = data
//        notifyDataSetChanged()
//    }

}