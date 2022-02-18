package kevin.android.petcoms.fragments.mypage.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kevin.android.petcoms.fragments.mypage.model.*
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MyPageViewModel @Inject constructor(private val repository: MyPageRepository) : ViewModel() {

    //내 계정정보 조회 API H1
    val myAccount: MutableLiveData<MyAccountModel> by lazy {
        MutableLiveData<MyAccountModel>()
    }
    fun getUserId(userId: Long) = viewModelScope.launch {
        myAccount.value = repository.getUserId(userId)
    }

    //강아지 등록 API H4
    val myPet: MutableLiveData<PostMyPetModel> by lazy {
        MutableLiveData<PostMyPetModel>()
    }
    fun postMyPet(userId: Long, postMyPet: PostMyPet) = viewModelScope.launch {
        myPet.value = repository.postMyPet(userId, postMyPet)
    }

    //내 핀 목록 조회 API H6
    private val _myPin = MutableLiveData<GetMyPinModel>()
    val myPin: LiveData<GetMyPinModel>
        get() = _myPin

    init {
        getMyPin(1)
    }

    fun getMyPin(userId: Long) = viewModelScope.launch {
        repository.getMyPin(userId).let { response ->
            if (response.isSuccessful) {
                _myPin.postValue(response.body())
            }
        }
    }

    //내 가족 목록 조회 API H7
    private val _myFamily = MutableLiveData<GetFamilyModel>()
    val myFamily: LiveData<GetFamilyModel>
        get() = _myFamily

    init {
        getMyFamily(2)
    }

    fun getMyFamily(userId: Long) = viewModelScope.launch {
        repository.getMyFamily(userId).let { response ->
            if (response.isSuccessful) {
                _myFamily.postValue(response.body())
            }
        }
    }

    //강아지별 다이어리 조회 API D1
    private val _myDiary = MutableLiveData<GetMyDiaryModel>()
    val myDiary: LiveData<GetMyDiaryModel>
        get() = _myDiary

    init {
        getMyDiary(1, "성북구대장탄이", "탄이")
    }

    fun getMyDiary(userId: Long, nickName: String, dogName: String) = viewModelScope.launch {
        repository.getMyDiary(userId, nickName, dogName).let { response ->
            if (response.isSuccessful) {
                _myDiary.postValue(response.body())
            }
        }
    }

    //다이어리 작성 API D2
    val postMyDiary: MutableLiveData<PostDiaryModel> by lazy {
        MutableLiveData<PostDiaryModel>()
    }
    fun postDiary(postDiary: PostDiary) = viewModelScope.launch {
        postMyDiary.value = repository.postDiary(postDiary)
    }

    //다이어리 수정 API D3
    val putMyDiary: MutableLiveData<PutDiaryModel> by lazy {
        MutableLiveData<PutDiaryModel>()
    }
    fun putDiary(diaryId: Long, putDiary: PutDiary) = viewModelScope.launch {
        putMyDiary.value = repository.putDiary(diaryId, putDiary)
    }

    //다이어리 삭제 API D4
    val deleteMyDiary: MutableLiveData<DeleteDiaryModel> by lazy {
        MutableLiveData<DeleteDiaryModel>()
    }
    fun deleteDiary(diaryId: Long) = viewModelScope.launch {
        deleteMyDiary.value = repository.deleteDiary(diaryId)
    }

    //다이어리 댓글 상세보기 API D6
    private val _comment = MutableLiveData<GetCommentModel>()
    val comment: LiveData<GetCommentModel>
        get() = _comment

    init {
        getComment(9)
    }

    fun getComment(diaryId: Long) = viewModelScope.launch {
        repository.getComment(diaryId).let { response ->
            if (response.isSuccessful) {
                _comment.postValue(response.body())
            }
        }
    }

    //다이어리 핀한수 상세보기 API D7
    private val _pinCount = MutableLiveData<GetPinCountModel>()
    val pinCount: LiveData<GetPinCountModel>
        get() = _pinCount

    init {
        getPinCount(9)
    }

    fun getPinCount(diaryId: Long) = viewModelScope.launch {
        repository.getPinCount(diaryId).let { response ->
            if (response.isSuccessful) {
                _pinCount.postValue(response.body())
            }
        }
    }

    //다이어리 댓글 작성 API D8
    val postComment: MutableLiveData<PostCommentModel> by lazy {
        MutableLiveData<PostCommentModel>()
    }
    fun postComment(postComment: PostComment) = viewModelScope.launch {
        this@MyPageViewModel.postComment.value = repository.postComment(postComment)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    val currentDate: LocalDate = LocalDate.now()

}