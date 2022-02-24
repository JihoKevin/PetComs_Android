package kevin.android.petcoms.fragments.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kevin.android.petcoms.databinding.BottomsheetCommentBinding
import kevin.android.petcoms.fragments.mypage.adapter.CommentAdapter
import kevin.android.petcoms.fragments.mypage.model.PostComment
import kevin.android.petcoms.fragments.mypage.viewmodel.MyPageViewModel
import kotlinx.android.synthetic.main.bottomsheet_comment.*

//@AndroidEntryPoint
//class CommentBottomSheet: BottomSheetDialogFragment() {
//
//    private var bottomSheetCommentBinding: BottomsheetCommentBinding? = null
//    private val viewModel: MyPageViewModel by activityViewModels()
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val binding = BottomsheetCommentBinding.inflate(inflater, container, false)
//        bottomSheetCommentBinding = binding
//
//        viewModel.comment.observe(this, Observer {
//            val adapter = CommentAdapter(it.response)
//            bottomSheetCommentBinding!!.rvComment.adapter = adapter
//            adapter.notifyDataSetChanged()
//        })
//
//        binding.postCommentInput.setEndIconOnClickListener {
//            if (post_comment.text!!.isEmpty()){
//                Toast.makeText(context, "댓글을 작성해주세요.", Toast.LENGTH_SHORT).show()
//                return@setEndIconOnClickListener
//            }
//
//            postComment()
//
//            //TODO text clear 추가 필요
//        }
//
//        return bottomSheetCommentBinding!!.root
//    }
//
//    private fun postComment() {
//        val postComment = PostComment(
//            1,
//            9,
//            bottomSheetCommentBinding!!.postComment.text.toString(),
//            1)
//        viewModel.postComment(postComment)
//    }
//
//    override fun onDestroyView() {
//        bottomSheetCommentBinding = null
//        super.onDestroyView()
//    }
//
//}