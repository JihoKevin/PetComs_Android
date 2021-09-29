package kevin.android.petcoms.fragments.mypage.repository

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kevin.android.petcoms.fragments.mypage.model.MyDiary
import kevin.android.petcoms.fragments.mypage.model.MyPets
import kevin.android.petcoms.fragments.mypage.model.TestModel
import kevin.android.petcoms.models.PostModel
import kevin.android.petcoms.network.Client
import kevin.android.petcoms.network.NetworkApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class MyPageRepository {

//    suspend fun getPost2(): Response<PostModel>{
//        return Client.retrofitService.getPost2()
//    }

    suspend fun getPostTest(): Response<TestModel>{
        return Client.retrofitService.getPostTest()
    }

    suspend fun getMyPets(): Response<MyPets>{
        return Client.retrofitService.getMyPets()
    }

}