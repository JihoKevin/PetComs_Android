package kevin.android.petcoms.fragments.record.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    CLICK
}

class RecordViewModel: ViewModel()  {
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