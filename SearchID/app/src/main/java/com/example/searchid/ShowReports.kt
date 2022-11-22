package com.example.searchid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.searchid.api.Reports
import com.example.searchid.api.SearchidApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowReports : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_reports)

        val recycleView = findViewById<RecyclerView>(R.id.Recycless)
        val btn_action = findViewById<Button>(R.id.btn_volver3)

        SearchidApiService.api
            .getAllReports()
            .enqueue(object: Callback<List<Reports>>{
                override fun onResponse(call: Call<List<Reports>>, response: Response<List<Reports>>

                ) {
                    if (response.isSuccessful){
                        recycleView.apply {
                            layoutManager= LinearLayoutManager(this@ShowReports)
                            adapter= ReportsAdapter(response.body() as MutableList<Reports>)
                        }

                    }
                }
                override fun onFailure(call: Call<List<Reports>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

        btn_action.setOnClickListener {
            startActivity(Intent(this, User_dashboard::class.java))
        }
    }
}