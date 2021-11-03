package kevin.android.petcoms.fragments.diary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.diary.repository.DiaryRepository
import kevin.android.petcoms.models.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(private val diaryRepository: DiaryRepository) : ViewModel() {
    private val _postLiveData = MutableLiveData<Response<PostModel>>()
    val postLiveData: LiveData<Response<PostModel>>
        get() = _postLiveData


    fun getPostViewModel() =
        viewModelScope.launch(Dispatchers.IO) {
            diaryRepository.getPost()?.let { response ->
                viewModelScope.launch(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        response.let {
                            _postLiveData.value = it
                        }
                    }
                }
            }
        }

}