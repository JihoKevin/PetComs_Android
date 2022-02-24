package kevin.android.petcoms.fragments.diary.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.ListAllDiaryBinding
import kevin.android.petcoms.fragments.diary.AccountProfileFragment
import kevin.android.petcoms.fragments.diary.model.GetAllDiary

class AllDiaryAdapter(private var data: List<GetAllDiary>, fragmentManager: FragmentManager) : RecyclerView.Adapter<AllDiaryAdapter.AllDiaryViewHolder>() {

    private var mFragmentManager : FragmentManager

    init {
        mFragmentManager = fragmentManager
    }

    class AllDiaryViewHolder(val binding: ListAllDiaryBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllDiaryViewHolder {
        val binding = ListAllDiaryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllDiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AllDiaryViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(data[position].imageUrl).into(holder.binding.dUserImg)
        holder.binding.dUserNickname.text = data[position].nickName
        holder.binding.dDate.text = data[position].registeredAt
        holder.binding.dContents.text = data[position].text
        holder.binding.dCommentCount.text = data[position].howManyComments.toString()
        holder.binding.dPinCount.text = data[position].howManyPins.toString()

        holder.binding.dUserImg.setOnClickListener{
            val accountProfileFragment = AccountProfileFragment()
            val transaction= mFragmentManager?.beginTransaction()
            transaction?.replace(R.id.diaryFragment, accountProfileFragment)?.commit()
        }

        holder.binding.dUserNickname.setOnClickListener{
            val accountProfileFragment = AccountProfileFragment()
            val transaction= mFragmentManager?.beginTransaction()
            transaction?.replace(R.id.diaryFragment, accountProfileFragment)?.commit()
        }

//        holder.binding.dComment.setOnClickListener {
//            val bottomSheet = CommentBottomSheet()
//            bottomSheet.show(mFragmentManager, bottomSheet.tag)
//        }

        holder.binding.dPin.setOnClickListener {

        }

        holder.binding.dPinCount.setOnClickListener {

        }
        fun pinEvent() {

        }
    }

    override fun getItemCount() = data.size

}