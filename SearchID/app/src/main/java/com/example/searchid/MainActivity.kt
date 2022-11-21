package com.example.searchid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

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

    override fun onResume() {
        super.onResume()
        setupObservables()
    }

    fun onLogin(username: String, password: String){
        vm.onLogin(username, password)
        setupObservables()
    }

    fun setupObservables(){
            vm.loggedIn.observe(this, Observer { loogedIn ->
                if(loogedIn) startActivity(Intent(this, User_dashboard::class.java))
            })
    }
}