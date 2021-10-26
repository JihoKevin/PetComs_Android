package kevin.android.petcoms.fragments.record.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.record.repository.RecordRepository
import kevin.android.petcoms.models.PostModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

enum class ActionType {
    CLICK
}
@HiltViewModel
class RecordViewModel @Inject constructor (private val recordRepository: RecordRepository) : ViewModel() {

    private var _postLiveData = MutableLiveData<Response<PostModel>>()
    val postLiveData: MutableLiveData<Response<PostModel>>
        get() = _postLiveData!!

    private val _currentValue = MutableLiveData<Float>()
    val currentValue: LiveData<Float>
        get() = _currentValue

    init {
        _currentValue.value = 1.2f
    }

    fun updateValue(actionType: ActionType, input: Float) {
        when (actionType) {
            ActionType.CLICK ->
                //_currentValue.value = _currentValue.value?.plus(input)
                _currentValue.value = input
        }
    }

    fun getPostViewModel() {
        viewModelScope.launch {
            val response = recordRepository.getPost()
            postLiveData.value = response
        }
    }
}