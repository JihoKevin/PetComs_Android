package kevin.android.petcoms.fragments.mypage.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.AddPetInfoBinding
import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.fragments.mypage.model.MyFamily
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.model.TestModel
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor (private val repository: MyPageRepository): ViewModel() {

//    반려견 리스트 뷰모델
    private val _myPetsList = MutableLiveData<List<TestModel>>()
    val myPetsList : LiveData<List<TestModel>>
        get() = _myPetsList

    init {
        getMyPetsVM()
    }

    fun getMyPetsVM() = viewModelScope.launch {
        repository.getTestModel().let { response ->
            if (response.isSuccessful){
                _myPetsList.postValue(response.body())
            } else{ }
        }
    }

//    내 가족 리스트 뷰모델
    private val _myFamList = MutableLiveData<List<TestModel>>()
    val myFamList : LiveData<List<TestModel>>
        get() = _myFamList

    init {
        getMyFamVM()
    }

    fun getMyFamVM() = viewModelScope.launch {
        repository.getTestModel().let { response ->
            if (response.isSuccessful){
                _myFamList.postValue(response.body())
            } else{ }
        }
    }

    // 내 다이어리 뷰모델
    private val _myDiaryList = MutableLiveData<List<TestModel>>()
    val myDiaryList : LiveData<List<TestModel>>
        get() = _myDiaryList

    init {
        getMyDiaryVM()
    }

    fun getMyDiaryVM() = viewModelScope.launch {
        repository.getTestModel().let { response ->
            if (response.isSuccessful){
                _myDiaryList.postValue(response.body())
            } else{ }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    val currentDate: LocalDate = LocalDate.now()

}