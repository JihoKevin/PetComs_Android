package kevin.android.petcoms.fragments.mypage.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.fragments.mypage.model.MyFamily

object MyFamBindingAdapter {

    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items : ArrayList<MyFamily>){

        if(recyclerView.adapter == null)
            recyclerView.adapter = MyFamAdapter()

        val myAdapter = recyclerView.adapter as MyFamAdapter

        myAdapter.myFamList = items
        myAdapter.notifyDataSetChanged()
    }

}