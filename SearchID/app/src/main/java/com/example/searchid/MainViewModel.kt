package com.example.searchid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchid.api.SearchidApiService
import com.example.searchid.api.UserSignup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    var loggedIn = MutableLiveData<Boolean>()

    var accestoken: String = ""
    var currentUsername: String? = null
    var currentUserId: Int? = null


    fun onSignup(username: String, first_name: String, last_name: String, email: String, password: String){
        val user = UserSignup(username,first_name,last_name,email,password)
        SearchidApiService.api
            .signup(user)
            .enqueue(object : Callback<UserSignup>{
                override fun onResponse(call: Call<UserSignup>, response: Response<UserSignup>) {

                }

                override fun onFailure(call: Call<UserSignup>, t: Throwable) {
                    handleError(t)
                }
            })
    }

    fun onLogout(){
        accestoken = ""
        currentUsername = null
        currentUserId = null
        loggedIn.value = false



    }

    private fun handleError(t: Throwable){
        t.localizedMessage
        t.printStackTrace()
    }
}