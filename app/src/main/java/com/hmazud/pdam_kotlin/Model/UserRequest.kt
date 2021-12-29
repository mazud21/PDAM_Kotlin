package com.hmazud.pdam_kotlin.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserRequest {
    @SerializedName("no_pelanggan")
    @Expose
    var no_pelanggan: String? = null

    @SerializedName("password")
    @Expose
    var password: String? = null
}