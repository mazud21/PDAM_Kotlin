package com.hmazud.pdam_kotlin.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserResponse {
    @SerializedName("status")
    @Expose
    var status: String? = null

    @SerializedName("data")
    @Expose
    var data: User? = null

    class User {
        @SerializedName("nama")
        @Expose
        var nama: String? = null

        @SerializedName("no_hp")
        @Expose
        var nohp: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("alamat")
        @Expose
        var alamat: String? = null

        @SerializedName("password")
        @Expose
        var password: String? = null
    }

}