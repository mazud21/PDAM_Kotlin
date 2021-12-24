package com.hmazud.pdam_kotlin.NetworkService

import com.hmazud.pdam_kotlin.model.SignInBody
import com.hmazud.pdam_kotlin.model.UserBody
import okhttp3.ResponseBody
import retrofit2.http.*

interface ApiInterface {
    @Headers("Content-Type:application/json")
    @POST("auth_tokens")
    fun signin(@Body info: SignInBody): retrofit2.Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("users")
    fun registerUser(
        @Body info: UserBody
    ): retrofit2.Call<ResponseBody>
}