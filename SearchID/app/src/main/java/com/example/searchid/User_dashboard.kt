package com.example.searchid

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchid.api.Documents
import com.example.searchid.api.SearchidApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class User_dashboard : AppCompatActivity() {

    private val ud: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_dashboard)

        val recycleView = findViewById<RecyclerView>(R.id.MyRecycleView)
        val logoutbtn = findViewById<Button>(R.id.btn_miPerfil)

        val reportbtn = findViewById<Button>(R.id.btn_reporarUnDocumento)
        val ver_report = findViewById<Button>(R.id.btn_buscarUnReport)

        val token = intent.getStringExtra("token")
        val id = intent.getIntExtra("id", 1)

        /*Api call for Documnets and adapterfor recycleView*/
        SearchidApiService.api
            .getAllPosts()
            .enqueue(object: Callback<List<Documents>> {
                override fun onResponse(call: Call<List<Documents>>, response: Response<List<Documents>>) {
                    if (response.isSuccessful){
                        recycleView.apply {
                            layoutManager=LinearLayoutManager(this@User_dashboard)
                            adapter= DocumentsAdapter(response.body() as MutableList<Documents>)
                        }

                    }
                }

                override fun onFailure(call: Call<List<Documents>>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("error", t.message.toString())
                }

            })

        /*Ver reports*/
        ver_report.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("View Reports")
                .setMessage("You want to check reports?")
                .setPositiveButton("Yes"){dialog, which -> startActivity(Intent(this, ShowReports::class.java))}
                .setNegativeButton("Cancel"){dialog, which -> dialog.dismiss()}
                .show()
            }


        /*Report button action*/
        reportbtn.setOnClickListener {startActivity(Intent(this, GenerateReport::class.java).also {
            it.putExtra("token",token)
            it.putExtra("id",id)
            startActivity(it)})
        }


        /*Logout function*/
        logoutbtn.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes"){dialog, which -> ud.onLogout()}
                .setNegativeButton("Cancel"){dialog, which -> dialog.dismiss()}
                .show()

        }

    }
    override fun onResume() {
        super.onResume()
        setupObservables()
    }

    fun setupObservables(){
        ud.loggedIn.observe(this, Observer { loogedIn ->
            if(loogedIn == false) startActivity(Intent(this, MainActivity::class.java))
        })
    }
}
