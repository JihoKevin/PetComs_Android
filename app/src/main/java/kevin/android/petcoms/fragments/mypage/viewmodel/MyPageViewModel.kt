package kevin.android.petcoms.fragments.mypage.viewmodel

import android.graphics.Insets.add
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kevin.android.petcoms.R
import kevin.android.petcoms.fragments.mypage.adapter.MyFamAdapter
import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.fragments.mypage.model.MyFamily
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kotlinx.coroutines.launch
import retrofit2.Response
import java.time.LocalDate

class MyPageViewModel(private val myPageRepository: MyPageRepository): ViewModel() {

//    lateinit var myDiaryAdapter: MyDiaryAdapter

//    반려견 리스트 뷰모델
    private val _myPetsList = MutableLiveData<ArrayList<MyPets>>()
    val myPetsList : LiveData<ArrayList<MyPets>>
        get() = _myPetsList

    private var petsList = ArrayList<MyPets>()

    init {
        petsList = arrayListOf(
            MyPets("콩순이"),
            MyPets("팥순이"),
            MyPets("또순이")
        )
        _myPetsList.value = petsList
    }

//    fun btnClick(){
//        val myPets = MyPets("탄이")
//        petsList.add(myPets)
//        _myPetsList.value = petsList
//    }

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

    fun btnAddFam(){
        val myFamily = MyFamily(R.drawable.ic_settings, "탄이엄마")
        famList.add(myFamily)
        _myFamList.value = famList
    }

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

//    fun fabClick(){
//        val myDiary = MyDiary(DUserImg = R.drawable.ic_settings, "탄이아빠", "2020.04.05")
//        diaryList.add(myDiary)
//        _myDiaryList.value = diaryList
//    }


//    private var _myDiaryList = MutableLiveData<Response<MyDiary>>()
//    val myDiaryList: MutableLiveData<Response<MyDiary>>
//        get() = _myDiaryList
//
//    init {
//        getMyDiaryModel()
//    }



//    val myDiaryList: MutableLiveData<Response<MyDiary>> = MutableLiveData()
//
//    fun getMyDiaryModel() {
//        viewModelScope.launch {
//            val response = myPageRepository.getMyDiaryData()
//            myDiaryList.value = response
//        }
//    }



//    fun getAdapter(): MyDiaryAdapter{
//        return myDiaryAdapter
//    }

//    val myResponse : MutableLiveData<Response<MyDiary>> = MutableLiveData()
//
//    fun getMyDiary() {
//        viewModelScope.launch {
//            val response = myPageRepository.getMyDiaryData()
//            myResponse.value = response
//        }
//    }

    val currentDate: LocalDate = LocalDate.now()

}