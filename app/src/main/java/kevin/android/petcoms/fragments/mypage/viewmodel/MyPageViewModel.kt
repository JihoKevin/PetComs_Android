package kevin.android.petcoms.fragments.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kevin.android.petcoms.R
import kevin.android.petcoms.fragments.mypage.MyDiary
import kevin.android.petcoms.fragments.mypage.MyPets

class MyPageViewModel: ViewModel() {
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

    fun btnClick(){
        val myPets = MyPets("탄이")
        petsList.add(myPets)
        _myPetsList.value = petsList
    }


    private val _myDiaryList = MutableLiveData<ArrayList<MyDiary>>()
    val myDiaryList : LiveData<ArrayList<MyDiary>>
        get() = _myDiaryList

    private var DiaryList = ArrayList<MyDiary>()

    init {
        DiaryList = arrayListOf(
            MyDiary(DUserImg = R.drawable.ic_settings, DUserNickname = "탄이아빠", DDate = "2020.04.05", DContents = "넘 즐거웡"),
            MyDiary(DUserImg = R.drawable.ic_settings, DUserNickname = "탄이아빠", DDate = "2020.04.05", DContents = "넘 즐거웡"),
            MyDiary(DUserImg = R.drawable.ic_settings, DUserNickname = "탄이아빠", DDate = "2020.04.05", DContents = "넘 즐거웡")
        )
        _myDiaryList.value = DiaryList
    }

    fun fabClick(){
        val myDiary = MyDiary(DUserImg = R.drawable.ic_settings, "탄이아빠", "2020.04.05", "다이어리 추가 임의 데이터")
        DiaryList.add(myDiary)
        _myDiaryList.value = DiaryList
    }

}