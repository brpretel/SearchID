package com.example.searchid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.searchid.api.CreateReport
import com.example.searchid.api.CreateReportResponse
import com.example.searchid.api.SearchidApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenerateReport: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.report)

        val token = intent.getStringExtra("token")

        val document_id = findViewById<EditText>(R.id.docu_num)
        val reportbtn = findViewById<Button>(R.id.btn_reportar)
        val btn_volver = findViewById<Button>(R.id.btn_volver)

        reportbtn.setOnClickListener {
            val docs = document_id.text.toString()

            if (docs.isEmpty()){
                print("username no")

            } else{
                createReport(docs,token!!)
                Thread.sleep(4_000)
                startActivity(Intent(this, User_dashboard::class.java))
            }
        }

        btn_volver.setOnClickListener {
            startActivity(Intent(this, User_dashboard::class.java))
        }

    }

    fun createReport(document_number : String, token:String){

        val report = CreateReport(document_number)
        SearchidApiService.api
            .createReport(report,token)
            .enqueue(object : Callback<CreateReportResponse> {
                override fun onResponse(
                    call: Call<CreateReportResponse>,
                    response: Response<CreateReportResponse>
                ) {
                    if (response.isSuccessful){
                        var l = response.body()
                        print(l)
                    }
                }

                override fun onFailure(call: Call<CreateReportResponse>, t: Throwable) {
                }

            })
    }
}