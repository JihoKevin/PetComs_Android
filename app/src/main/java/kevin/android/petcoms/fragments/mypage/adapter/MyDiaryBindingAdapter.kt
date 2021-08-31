package kevin.android.petcoms.fragments.mypage.adapter

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.fragments.mypage.MyDiary
import retrofit2.Response

object MyDiaryBindingAdapter {

    @BindingAdapter("items")
    @JvmStatic
    fun setItems(recyclerView: RecyclerView, items : MutableList<MyDiary>){

        if(recyclerView.adapter == null)
            recyclerView.adapter = MyDiaryAdapter()

        val myAdapter = recyclerView.adapter as MyDiaryAdapter

        myAdapter.myDiaryList = items
        myAdapter.notifyDataSetChanged()
    }

}