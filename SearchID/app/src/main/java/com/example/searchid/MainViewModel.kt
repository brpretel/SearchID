package com.example.searchid

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.searchid.api.Documents
import com.example.searchid.api.SearchidApiService
import com.example.searchid.api.UserLoginResponse
import com.example.searchid.api.UserSignup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    var loggedIn = MutableLiveData<Boolean>()


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

                    }
                }

                override fun onFailure(call: Call<List<Documents>>, t: Throwable) {
                    handleError(t)
                }

            })
    }


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


    fun onLogin(username: String, password : String){
        SearchidApiService.api
            .login(username, password)
            .enqueue(object : Callback<UserLoginResponse>{
                override fun onResponse(
                    call: Call<UserLoginResponse>,
                    response: Response<UserLoginResponse>
                ) {
                    if (response.isSuccessful){
                        accestoken = response.body()?.accesToken.toString()
                        currentUsername= response.body()?.username
                        currentUserId = response.body()?.user_Id

                        if (accestoken.equals("none")){
                            print("Intenta de nuevo")
                        }else{
                            loggedIn.value = true
                            getAllPosts()
                        }
                    }
                }

                override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
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