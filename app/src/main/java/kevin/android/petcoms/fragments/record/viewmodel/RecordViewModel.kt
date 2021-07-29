package kevin.android.petcoms.fragments.record.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kevin.android.petcoms.fragments.record.repository.RecordRepository

enum class ActionType{
    CLICK
}

class RecordViewModel(private val recordRepository: RecordRepository): ViewModel()  {
    private val _currentValue = MutableLiveData<Float>()
    val currentValue: LiveData<Float>
        get() = _currentValue

    init {
        _currentValue.value = 1.2f
    }

    fun updateValue(actionType: ActionType, input: Float){
        when(actionType){
            ActionType.CLICK ->
                //_currentValue.value = _currentValue.value?.plus(input)
            _currentValue.value = input
        }
    }

}