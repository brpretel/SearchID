package com.example.searchid

import android.content.Intent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchid.api.Documents
import com.example.searchid.api.SearchidApiService
import com.example.searchid.api.UserLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    var loogedIn = MutableLiveData<Boolean>()

    private  var accestoken: String = ""
    private var currentUsername: String? = null
    private var currentUserId: Int? = null

    init {
       // getAllPosts()
    }

    fun getAllPosts(){
        SearchidApiService.api
            .getAllPosts()
            .enqueue(object: Callback<List<Documents>> {
                override fun onResponse(call: Call<List<Documents>>, response: Response<List<Documents>>) {
                    if (response.isSuccessful){
                        val list= response.body()
                    }
                }

                override fun onFailure(call: Call<List<Documents>>, t: Throwable) {
                    val i = 0
                }

            })
    }

    fun onLogin(username: String, password : String){
        SearchidApiService.api
            .login(username, password)
            .enqueue(object : Callback<UserLoginResponse>{
                override fun onResponse(
                    call: Call<UserLoginResponse>,
                    response: Response<UserLoginResponse>
                ) {
                    if (response.isSuccessful){
                        val list= response.body()
                        accestoken = response.body()?.accesToken.toString()
                        currentUsername= response.body()?.username
                        currentUserId = response.body()?.user_Id

                        if (accestoken.equals("none")){
                            print("Intenta de nuevo")
                        }else{
                            loogedIn.value = true
                            getAllPosts()


                        }
                    }
                }

                override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                    val i = 0
                }

            })
    }
}