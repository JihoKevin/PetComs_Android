package kevin.android.petcoms.fragments.statistics.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class StatisticsViewModel {

    private val _currentValue = MutableLiveData<Float>()
    val currentValue: LiveData<Float>
        get() = _currentValue

    init {
        _currentValue.value = 0f
    }

}