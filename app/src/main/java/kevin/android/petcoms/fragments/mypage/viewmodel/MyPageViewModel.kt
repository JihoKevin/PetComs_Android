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
    private val _myFamList = MutableLiveData<ArrayList<MyFamily>>()
    val myFamList : LiveData<ArrayList<MyFamily>>
        get() = _myFamList

    private var famList = ArrayList<MyFamily>()

    init {
        famList = arrayListOf(
            MyFamily(myFamImg = R.drawable.ic_settings, "탄이아빠"),
            MyFamily(myFamImg = R.drawable.ic_settings, "탄이삼촌")
        )
        _myFamList.value = famList
    }

//    fun btnAddFam(){
//        val myFamily = MyFamily(R.drawable.ic_settings, "탄이엄마")
//        famList.add(myFamily)
//        _myFamList.value = famList
//    }

    // 내 다이어리 뷰모델
    private val _myDiaryList = MutableLiveData<ArrayList<MyDiary>>()
    val myDiaryList : LiveData<ArrayList<MyDiary>>
        get() = _myDiaryList

    private var diaryList = ArrayList<MyDiary>()

    init {
        diaryList = arrayListOf(
            MyDiary(DUserImg = R.drawable.ic_settings, "탄이아빠", "2020.04.05", "재밌었다"),
            MyDiary(DUserImg = R.drawable.ic_settings, "탄이삼촌", "2020.04.05", "즐거웠다")
        )
        _myDiaryList.value = diaryList
    }

    @RequiresApi(Build.VERSION_CODES.O)
    val currentDate: LocalDate = LocalDate.now()

}