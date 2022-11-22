package com.example.searchid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity


class SignUp : AppCompatActivity() {

    private val rg: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        val username = findViewById<EditText>(R.id.et_user_names)
        val first_name = findViewById<EditText>(R.id.et_first_name)
        val last_name = findViewById<EditText>(R.id.et_last_name)
        val email = findViewById<EditText>(R.id.et_email)
        val password = findViewById<EditText>(R.id.et_password_sign_up)

        val signupbtn = findViewById<Button>(R.id.btn_SignUpScreen)

        signupbtn.setOnClickListener {
            val username = username.text.toString()
            val first_name = first_name.text.toString()
            val last_name = last_name.text.toString()
            val email = email.text.toString()
            val password = password.text.toString()

            if (username.isEmpty()){
                print("username no")
            } else if (password.isEmpty()) {
                print("password no")
            }else if (first_name.isEmpty()){
                print("firstname no")
            }else if (last_name.isEmpty()){
                print("lastname no")
            }else if (email.isEmpty()){
                print("email no")
            } else{
                register(username,first_name,last_name,email,password)
            }
        }

    }

    fun register(username: String, first_name: String, last_name: String, email: String, password: String){
        rg.onSignup(username,first_name,last_name,email,password)
        startActivity(Intent(this, MainActivity::class.java))
    }

}