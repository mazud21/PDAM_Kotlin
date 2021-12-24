package com.hmazud.pdam_kotlin.User

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hmazud.pdam_kotlin.NetworkService.ApiInterface
import com.hmazud.pdam_kotlin.NetworkService.RetrofitInstance
import com.hmazud.pdam_kotlin.R
import com.hmazud.pdam_kotlin.model.SignInBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var etIdPelanggan = findViewById<EditText>(R.id.etNoID)
        var etPassword = findViewById<EditText>(R.id.etPassword)

        var btnMasuk = findViewById<Button>(R.id.btnMasuk)

        btnMasuk.setOnClickListener {
            signin(etIdPelanggan.text.toString(), etPassword.text.toString())
        }

    }

    private fun signin(email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = SignInBody(email, password)
        retIn.signin(signInInfo).enqueue(object : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@Login,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Toast.makeText(this@Login, "Login success!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@Login, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}