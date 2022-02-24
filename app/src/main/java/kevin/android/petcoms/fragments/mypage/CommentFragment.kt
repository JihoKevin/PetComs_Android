package kevin.android.petcoms.fragments.mypage

import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kevin.android.petcoms.R
import kevin.android.petcoms.base.PetComsBaseFragment
import kevin.android.petcoms.databinding.FragmentCommentBinding
import kevin.android.petcoms.fragments.mypage.adapter.CommentAdapter
import kevin.android.petcoms.fragments.mypage.model.PostComment
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kotlinx.android.synthetic.main.bottomsheet_comment.*

class CommentFragment : PetComsBaseFragment<FragmentCommentBinding>(R.layout.fragment_comment) {

    private val viewModel: MyPageViewModel by activityViewModels()

    override fun initViews(view: View) {
//        binding.cUserNickname.text = arguments!!.getString("user_nickname")
        binding.cContent.text = arguments!!.getString("content")
        binding.cDate.text = arguments!!.getString("date")
        viewModel.getComment(arguments?.getLong("diaryID")!!)
        initRecyclerview()
        initButton()
    }

    override fun observeData() {

    }

    private fun initRecyclerview() {
        viewModel.comment.observe(this, Observer {
            val adapter = CommentAdapter(it.response)
            binding.rvComment.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    private fun initButton() {
        binding.postCommentInput.setEndIconOnClickListener {
            if (post_comment.text!!.isEmpty()){
                Toast.makeText(context, "댓글을 작성해주세요.", Toast.LENGTH_SHORT).show()
                return@setEndIconOnClickListener
            }

            postComment()

            //TODO text clear 추가 필요
        }
    }

    private fun postComment() {
        val postComment = PostComment(
            1,
            arguments?.getLong("diaryID")!!,
            binding.postComment.text.toString(),
            1)
        viewModel.postComment(postComment)
    }

}