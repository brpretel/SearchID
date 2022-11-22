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


class RegisterDocument : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_document)

        var cd = findViewById<EditText>(R.id.misDocsCedula)


        var btn_volv = findViewById<Button>(R.id.btn_volver5)
        var btn_guardar = findViewById<Button>(R.id.btn_guardar)

        var cedula = cd.text.toString()
        var otro = cd.text.toString()

        btn_volv.setOnClickListener {
            startActivity(Intent(this, User_dashboard::class.java))
        }

        btn_guardar.setOnClickListener {
            Thread.sleep(4_000)
            startActivity(Intent(this, User_dashboard::class.java))
            createReport(cedula,1,otro)
        }
    }
    fun createReport(document_number : String, id:Int?, token:String){

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
                    }
                }

                override fun onFailure(call: Call<CreateReportResponse>, t: Throwable) {
                }

            })
    }

}