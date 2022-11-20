package com.example.searchid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer


class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user_name = findViewById<EditText>(R.id.et_user_name)
        val etpassword = findViewById<EditText>(R.id.et_password)
        val btnsubmit = findViewById<Button>(R.id.btn_submit)


        btnsubmit.setOnClickListener {
            val username = user_name.text.toString()
            val password = etpassword.text.toString()
            Toast.makeText(this@MainActivity, username, Toast.LENGTH_LONG).show()

            if (username.isEmpty()){
                print("username no")
            } else if (password.isEmpty()) {
                print("password no")
            } else{
                onLogin(username,password)
            }
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
            vm.loogedIn.observe(this, Observer { loogedIn ->
                if(loogedIn) startActivity(Intent(this, Pantalla2::class.java))
            })
    }
}