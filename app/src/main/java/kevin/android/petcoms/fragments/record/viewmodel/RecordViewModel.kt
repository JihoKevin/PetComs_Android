package kevin.android.petcoms.fragments.record.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.record.model.CommentModel
import kevin.android.petcoms.fragments.record.repository.RecordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

enum class ActionType {
    CLICK
}

@HiltViewModel
class RecordViewModel @Inject constructor(private val recordRepository: RecordRepository) :
    ViewModel() {

    val comments: MutableLiveData<CommentModel> by lazy {
        MutableLiveData<CommentModel>()
    }

    public fun getComments(diaryId: Long) = viewModelScope.launch {

        comments.value = recordRepository.getComment(diaryId)

    }

}