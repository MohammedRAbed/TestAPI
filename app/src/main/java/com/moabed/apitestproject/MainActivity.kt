package com.moabed.apitestproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.moabed.apitestproject.models.Models
import com.moabed.apitestproject.remote.Methods
import com.moabed.apitestproject.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {

    lateinit var getBtn : Button
    lateinit var dataText : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getBtn = findViewById(R.id.get_btn)
        dataText = findViewById(R.id.data_text)

        getBtn.setOnClickListener {

            val methods = RetrofitClient.getClient()?.create(Methods::class.java)

            methods?.getAllData()!!.enqueue( object : Callback<Models> {

                @SuppressLint("SetTextI18n")
                override fun onResponse(call: Call<Models>, response: Response<Models>) {
                    Toast.makeText(this@MainActivity,"Succeed",Toast.LENGTH_SHORT).show()
                    val responseItem = response.body()!!.data.size-1
                    dataText.text = "You got: ${response.body()!!.data.get((0..(responseItem)).random()).firstName}"
                }

                override fun onFailure(call: Call<Models>, t: Throwable) {
                    Toast.makeText(this@MainActivity,"Failed",Toast.LENGTH_SHORT).show()
                    dataText.text = t.message
                }

            })
        }
    }
}