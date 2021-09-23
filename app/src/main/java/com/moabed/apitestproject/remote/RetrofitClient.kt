package com.moabed.apitestproject.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {

        private val BASE_URL = "https://reqres.in/api/"
        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit
        }
    }
}