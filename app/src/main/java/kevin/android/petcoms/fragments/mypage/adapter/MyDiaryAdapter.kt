package kevin.android.petcoms.fragments.mypage.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.PrefUtil
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.ListMyDiaryBinding
import kevin.android.petcoms.fragments.mypage.CommentFragment
import kevin.android.petcoms.fragments.mypage.UpdateDiary
import kevin.android.petcoms.fragments.mypage.model.GetMyDiary
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kotlinx.android.synthetic.main.list_my_diary.view.*

class MyDiaryAdapter(private var data: List<GetMyDiary>, fragmentManager: FragmentManager) : RecyclerView.Adapter<MyDiaryAdapter.MyDiaryViewHolder>() {

    private var mFragmentManager: FragmentManager

    init {
        mFragmentManager = fragmentManager
    }

    inner class MyDiaryViewHolder(val binding: ListMyDiaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyDiaryViewHolder {
        val binding = ListMyDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyDiaryViewHolder, position: Int) {
//        holder.binding.dUserNickname.text =
        holder.binding.diaryId.text = data[position].diaryId.toString()
        holder.binding.dDate.text = data[position].creatAt
        holder.binding.dContents.text = data[position].text

        holder.itemView.setOnClickListener {
            val commentFragment = CommentFragment()
            val bundle = Bundle()

            bundle.putLong("diaryID", holder.binding.diaryId.text.toString().toLong())
            bundle.putString("date", holder.binding.dDate.text.toString())
            bundle.putString("content", holder.binding.dContents.text.toString())

            commentFragment.arguments = bundle

            mFragmentManager.beginTransaction().replace(R.id.myPageFragment, commentFragment).commit()
        }
        holder.binding.dComment.setOnClickListener {
            val commentFragment = CommentFragment()
            val bundle = Bundle()

            bundle.putLong("diaryID", holder.binding.diaryId.text.toString().toLong())
            bundle.putString("date", holder.binding.dDate.text.toString())
            bundle.putString("content", holder.binding.dContents.text.toString())

            commentFragment.arguments = bundle
            mFragmentManager.beginTransaction().replace(R.id.myPageFragment, commentFragment).commit()
        }
        holder.binding.dPin.setOnClickListener {
            //TODO Pin Fragment 추가 필요
        }
        holder.binding.dSetting.setOnClickListener {
            val updateDiary = UpdateDiary()
            val bundle = Bundle()
            val diarySettingMenu = PopupMenu(holder.binding.root.context, it)
            diarySettingMenu.menuInflater.inflate(R.menu.diary_setting_menu, diarySettingMenu.menu)
            diarySettingMenu.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.edit_diary -> {

                        bundle.putLong("diaryID", holder.binding.diaryId.text.toString().toLong())
                        bundle.putString("date", holder.binding.dDate.text.toString())
                        bundle.putString("content", holder.binding.dContents.text.toString())

                        updateDiary.arguments = bundle

                        mFragmentManager.beginTransaction().replace(R.id.myPageFragment, updateDiary).commit()

                        true
                    }
                    R.id.delete_diary -> {
                        AlertDialog.Builder(holder.binding.root.context)
                            .setTitle("삭제")
                            .setMessage("정말로 삭제하시겠습니까?")
                            .setPositiveButton("확인"){
                                    dialog,_->
                                //TODO 댓글삭제 API
                                notifyDataSetChanged()
                                Toast.makeText(holder.binding.root.context, "다이어리가 삭제되었습니다.", Toast.LENGTH_SHORT).show()
                                dialog.dismiss()
                            }
                            .setNegativeButton("취소"){
                                    dialog,_->
                                dialog.dismiss()
                            }
                            .create()
                            .show()
                        true
                    }
                    R.id.change_private -> {
                        //TODO 공개/비공개 전환
                        true
                    }
                    else -> true
                }
            }
            diarySettingMenu.show()
        }
    }

    override fun getItemCount() = data.size

}