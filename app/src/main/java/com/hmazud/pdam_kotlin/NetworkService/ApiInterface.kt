package com.hmazud.pdam_kotlin.NetworkService

import com.hmazud.pdam_kotlin.Model.UserRequest
import com.hmazud.pdam_kotlin.Model.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @POST("Pdam_pelangganLogin")
    fun signin(@Body userRequest: UserRequest): Call<UserResponse>

}