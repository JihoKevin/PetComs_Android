package kevin.android.petcoms.fragments.mypage.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

}