package kevin.android.petcoms.fragments.mypage.viewmodel

import android.graphics.Insets.add
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kevin.android.petcoms.R
import kevin.android.petcoms.databinding.AddPetInfoBinding
import kevin.android.petcoms.fragments.mypage.adapter.MyFamAdapter
import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.fragments.mypage.model.MyFamily
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.model.TestModel
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kevin.android.petcoms.models.PostModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate

class MyPageViewModel(private val myPageRepository: MyPageRepository): ViewModel() {

//    lateinit var myDiaryAdapter: MyDiaryAdapter
private var addPetInfoBinding : AddPetInfoBinding? = null

//    반려견 리스트 뷰모델
    private val _myPetsList = MutableLiveData<List<MyPets>>()
    val myPetsList : MutableLiveData<List<MyPets>>
        get() = _myPetsList

    fun getMyPetsVM() {
        viewModelScope.launch {
            val response = myPageRepository.getMyPets()
            _myPetsList.postValue(response)
        }
    }

//    private var petsList = ArrayList<MyPets>()

//    init {
//        petsList = arrayListOf(
//            MyPets("콩순이"),
//            MyPets("팥순이"),
//            MyPets("또순이")
//        )
//        _myPetsList.value = petsList
//    }

//    fun btnClick(){
//        val myPets = MyPets(addPetInfoBinding?.editPetName?.text.toString())
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
//        val myDiary = MyDiary(DUserImg = R.drawable.ic_settings, "탄이아빠", "2020.04.05", newDiary)
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

//    private var _postLiveData2 = MutableLiveData<Response<PostModel>>()
//    val postLiveData2: MutableLiveData<Response<PostModel>>
//        get() = _postLiveData2!!
//
//    fun getPostViewModel2() {
//        viewModelScope.launch {
//            val response = myPageRepository.getPost2()
//            postLiveData2.value = response
//        }
//    }

    private var _testData = MutableLiveData<Response<TestModel>>()
    val testData: MutableLiveData<Response<TestModel>>
        get() = _testData!!

    fun getPostTestVM() {
        viewModelScope.launch {
            val response = myPageRepository.getPostTest()
            testData.value = response
        }
    }

//    Client.retrofitService.getPost3().enqueue(object : Callback<PostModel> {
//        override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
//            //성공
//            if(response.isSuccessful) {
//                var postModel: PostModel = response.body()!!
//            }
//        }
//        override fun onFailure(call: Call<PostModel>, t: Throwable) {
//            //실패
//        }
//    })

    val currentDate: LocalDate = LocalDate.now()

}