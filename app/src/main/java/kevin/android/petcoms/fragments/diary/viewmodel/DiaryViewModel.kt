package kevin.android.petcoms.fragments.diary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.diary.model.GetAllDiaryModel
import kevin.android.petcoms.fragments.diary.model.GetDogProfileModel
import kevin.android.petcoms.fragments.diary.model.GetUserProfileModel
import kevin.android.petcoms.fragments.diary.repository.DiaryRepository
import kotlinx.coroutines.launch
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

    //H5
    val dogProfile: MutableLiveData<GetDogProfileModel> by lazy {
        MutableLiveData<GetDogProfileModel>()
    }

    fun getDogProfile(nickName: String, dogName: String) = viewModelScope.launch {
        dogProfile.value = repository.getDogProfile(nickName, dogName)
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

//    private val _dogProfile = MutableLiveData<GetDogProfileModel>()
//    val dogProfile: LiveData<GetDogProfileModel>
//        get() = _dogProfile
//
//    init {
//        getDogProfile("")
//    }
//
//    fun getDogProfile(nickName: String, dogName: String) = viewModelScope.launch {
//        repository.getDogProfile(nickName, dogName).let { response ->
//            if (response.isSuccessful) {
//                _dogProfile.postValue(response.body())
//            }
//        }
//    }

}