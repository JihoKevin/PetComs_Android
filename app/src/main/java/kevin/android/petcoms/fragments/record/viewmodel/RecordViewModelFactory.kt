package kevin.android.petcoms.fragments.record.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kevin.android.petcoms.fragments.record.repository.RecordRepository

class RecordViewModelFactory(private val repository: RecordRepository) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecordViewModel::class.java)) {
            return RecordViewModel(repository) as T
        }
        throw IllegalArgumentException("Record ViewModelFactory Exception")
    }
}