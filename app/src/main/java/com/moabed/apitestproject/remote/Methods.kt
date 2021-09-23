package com.moabed.apitestproject.remote

import android.graphics.ColorSpace
import com.moabed.apitestproject.models.Models
import retrofit2.Call
import retrofit2.http.GET

interface Methods {

    @GET("users?page=2")
    fun getAllData(): Call<Models>
}