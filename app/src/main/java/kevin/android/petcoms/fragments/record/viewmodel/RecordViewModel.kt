package kevin.android.petcoms.fragments.record.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.record.repository.RecordRepository
import javax.inject.Inject

enum class ActionType {
    CLICK
}

@HiltViewModel
class RecordViewModel @Inject constructor(private val recordRepository: RecordRepository) :
    ViewModel() {





}