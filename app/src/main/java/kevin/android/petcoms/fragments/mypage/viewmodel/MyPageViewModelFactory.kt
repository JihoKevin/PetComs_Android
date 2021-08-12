package kevin.android.petcoms.fragments.mypage.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kevin.android.petcoms.fragments.mypage.repository.MyPageRepository

class MyPageViewModelFactory(private val repository: MyPageRepository) : ViewModelProvider.NewInstanceFactory()  {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyPageViewModel::class.java)) {
            return MyPageViewModel(repository) as T
        }
        throw IllegalArgumentException("MyPage ViewModelFactory Exception")
    }

}