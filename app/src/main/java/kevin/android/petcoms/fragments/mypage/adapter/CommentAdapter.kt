package kevin.android.petcoms.fragments.mypage.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kevin.android.petcoms.databinding.ListCommentBinding
import kevin.android.petcoms.fragments.mypage.model.GetComment

class CommentAdapter(private var data: List<GetComment>): RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    class CommentViewHolder(val binding: ListCommentBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding = ListCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.binding.cUserNickname.text = data[position].nickname
        holder.binding.comment.text = data[position].text
        holder.binding.cTime.text = data[position].aftertime

        holder.binding.cComment.setOnClickListener {

        }
    }

    override fun getItemCount() = data.size
}