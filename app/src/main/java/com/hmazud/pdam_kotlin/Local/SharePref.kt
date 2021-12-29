package com.hmazud.pdam_kotlin.Local

import android.content.Context
import android.content.SharedPreferences

object SharePref {
    private const val NAME = "PDAM_KOTLIN"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    //SharedPreferences variables
    private val IS_LOGIN = Pair("is_login", false)
    private val NAMA = Pair("nama", "")
    private val NO_HP = Pair("nohp", "")
    private val EMAIL = Pair("email", "")
    private val ALAMAT = Pair("alamat", "")
    private val PASSWORD = Pair("password", "")

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    //an inline function to put variable and save it
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    //SharedPreferences variables getters/setters
    var isLogin: Boolean
        get() = preferences.getBoolean(IS_LOGIN.first, IS_LOGIN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LOGIN.first, value)
        }

    var nama: String
        get() = preferences.getString(NAMA.first, NAMA.second) ?: ""
        set(value) = preferences.edit {
            it.putString(NAMA.first, value)
        }

    var email: String
        get() = preferences.getString(EMAIL.first, EMAIL.second) ?: ""
        set(value) = preferences.edit {
            it.putString(EMAIL.first, value)
        }

    var nohp: String
        get() = preferences.getString(NO_HP.first, NO_HP.second) ?: ""
        set(value) = preferences.edit {
            it.putString(NO_HP.first, value)
        }

    var alamat: String
        get() = preferences.getString(ALAMAT.first, ALAMAT.second) ?: ""
        set(value) = preferences.edit {
            it.putString(ALAMAT.first, value)
        }

    var password: String
        get() = preferences.getString(PASSWORD.first, PASSWORD.second) ?: ""
        set(value) = preferences.edit {
            it.putString(PASSWORD.first, value)
        }

}