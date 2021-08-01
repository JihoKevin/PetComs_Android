package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.ListMyPetsBinding
import kevin.android.petcoms.fragments.mypage.MyPets

class MyPetsAdapter(val myPetsList: ArrayList<MyPets>): RecyclerView.Adapter<MyPetsAdapter.MyPetsViewHolder>() {

    override fun getItemCount(): Int {
        return myPetsList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPetsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_my_pets, parent, false)
        return MyPetsViewHolder(view)
//        val binding = ListMyPetsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return MyPetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyPetsViewHolder, position: Int) {
        holder.myPetsName.text = myPetsList.get(position).myPetsName
//        holder.onBind(myPetsList[position])
    }

    class MyPetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val myPetsName = itemView.findViewById<TextView>(R.id.pets_name)
    }

}