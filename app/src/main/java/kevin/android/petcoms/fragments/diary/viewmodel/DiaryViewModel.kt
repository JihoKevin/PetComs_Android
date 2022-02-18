package kevin.android.petcoms.fragments.diary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.diary.model.GetAllDiaryModel
import kevin.android.petcoms.fragments.diary.model.GetUserProfileModel
import kevin.android.petcoms.fragments.diary.repository.DiaryRepository
import kevin.android.petcoms.fragments.mypage.model.GetMyDiaryModel
import kevin.android.petcoms.fragments.mypage.model.MyAccountModel
import kevin.android.petcoms.models.PostModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class DiaryViewModel @Inject constructor(private val repository: DiaryRepository) : ViewModel() {

    //S1
    private val _allDiary = MutableLiveData<GetAllDiaryModel>()
    val allDiary: LiveData<GetAllDiaryModel>
        get() = _allDiary

    init {
        getAllDiary("CURRENT")
    }

    fun getAllDiary(sorted: String) = viewModelScope.launch {
        repository.getAllDiary(sorted).let { response ->
            if (response.isSuccessful) {
                _allDiary.postValue(response.body())
            }
        }
    }

    //S9

    val userProfile: MutableLiveData<GetUserProfileModel> by lazy {
        MutableLiveData<GetUserProfileModel>()
    }
    fun getUserProfile(userName: String) = viewModelScope.launch {
        userProfile.value = repository.getUserProfile(userName)
    }

//    private val _userProfile = MutableLiveData<GetUserProfileModel>()
//    val userProfile: LiveData<GetUserProfileModel>
//        get() = _userProfile
//
//    init {
//        getUserProfile("성북구대장탄이")
//    }
//
//    fun getUserProfile(userName: String) = viewModelScope.launch {
//        repository.getUserProfile(userName).let { response ->
//            if (response.isSuccessful) {
//                _userProfile.postValue(response.body())
//            }
//        }
//    }

}