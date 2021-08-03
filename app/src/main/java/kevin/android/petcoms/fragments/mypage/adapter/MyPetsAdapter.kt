package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.ListMyPetsBinding
import kevin.android.petcoms.fragments.mypage.MyPets

class MyPetsAdapter(): RecyclerView.Adapter<MyPetsAdapter.MyPetsViewHolder>() {

    var myPetsList = mutableListOf<MyPets>()

    class MyPetsViewHolder(val binding: ListMyPetsBinding) : RecyclerView.ViewHolder(binding.root) {
//        val myPetsName = itemView.findViewById<TextView>(R.id.pets_name)
        fun bind(currentMyPets: MyPets) {
            binding.myPets = currentMyPets
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPetsViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_my_pets, parent, false)
//        return MyPetsViewHolder(view)
        val binding = ListMyPetsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPetsViewHolder, position: Int) {
//        holder.myPetsName.text = myPetsList.get(position).myPetsName
        holder.bind(myPetsList[position])
    }

    override fun getItemCount(): Int {
        return myPetsList.size
    }

    fun setData(data : ArrayList<MyPets>){
        myPetsList = data
        notifyDataSetChanged()
    }

}