package com.fnbt.tn.paymentsystem

import com.fnbt.tn.paymentsystem.model.UserData
import com.fnbt.tn.paymentsystem.model.UserDataAnswer
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface ForumService {

    @POST("/")
    fun sendUserInfo(@Body userData: UserData): Call<UserDataAnswer>

    companion object {
        operator fun invoke():ForumService {
            return Retrofit.Builder()
                    .baseUrl("http://46.101.232.93:443")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ForumService::class.java)
        }
    }

}