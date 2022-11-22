package com.example.searchid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import com.example.searchid.api.SearchidApiService
import com.example.searchid.api.UserLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()
    var accestoken: String = ""
    var currentUsername: String? = null
    var currentUserId: Int? = null
    var loggedIn = MutableLiveData<Boolean>()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user_name = findViewById<EditText>(R.id.et_user_name)
        val etpassword = findViewById<EditText>(R.id.et_password)
        val btnsubmit = findViewById<Button>(R.id.btn_submit)
        val btnSignUp = findViewById<Button>(R.id.btn_SignUp)


        btnsubmit.setOnClickListener {
            val username = user_name.text.toString()
            val password = etpassword.text.toString()

            if (username.isEmpty()){
                print("username no")
            } else if (password.isEmpty()) {
                print("password no")
            } else{
                Toast.makeText(this@MainActivity, username, Toast.LENGTH_LONG).show()
                onLogin(username,password)
            }
        }

        btnSignUp.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

    }

    fun onLogin(username: String, password : String){
        SearchidApiService.api
            .login(username, password)
            .enqueue(object : Callback<UserLoginResponse> {
                override fun onResponse(
                    call: Call<UserLoginResponse>,
                    response: Response<UserLoginResponse>
                ) {
                    if (response.isSuccessful){

                        if (accestoken.equals("none")){
                            print("Intenta de nuevo")
                        }else{
                            loggedIn.value = true
                            accestoken = "${response.body()?.accesstoken}".toString()
                            currentUsername= response.body()?.username.toString()
                            currentUserId = response.body()?.user_Id!!.toInt()
                            setupObservables(accestoken, currentUserId!!)
                        }
                    }
                }

                override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                }

            })
    }

    fun setupObservables(x:String,y:Int){
        startActivity(Intent(this, User_dashboard::class.java).also {
            it.putExtra("token",x)
            it.putExtra("id",y)
            startActivity(it)
        })
    }
}