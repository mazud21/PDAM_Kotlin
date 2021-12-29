package com.hmazud.pdam_kotlin.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.hmazud.pdam_kotlin.Dashboard
import com.hmazud.pdam_kotlin.Local.SharePref
import com.hmazud.pdam_kotlin.NetworkService.ApiInterface
import com.hmazud.pdam_kotlin.NetworkService.RetrofitInstance
import com.hmazud.pdam_kotlin.R
import com.hmazud.pdam_kotlin.Model.UserRequest
import com.hmazud.pdam_kotlin.Model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etIdPelanggan = findViewById<EditText>(R.id.etNoID)
        val etPassword = findViewById<EditText>(R.id.etPassword)

        val btnMasuk = findViewById<Button>(R.id.btnMasuk)

        SharePref.init(this)

        btnMasuk.setOnClickListener {
            signin(etIdPelanggan.text.toString(), etPassword.text.toString())
            Log.d("TAG_TEST_TEXT0", "onCreate: ${etIdPelanggan.text} ${etPassword.text}")
            //signin("1","11111111")
        }

    }

    fun signin(idp: String, pass: String){

        val req = UserRequest()
        req.no_pelanggan = idp
        req.password = pass

        Log.d("TAG_TEST_TEXT1", "onCreate: ${req.no_pelanggan} ${req.password}")

        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        retIn.signin(req).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                val user = response.body()
                Log.d("TAG_TEST_TEXT2", "onCreate: $user")

                try {
                    if (response.code() == 200){
                        Toast.makeText(this@Login, "Login Sukses ${user!!.data?.nama}", Toast.LENGTH_LONG).show()

                        SharePref.isLogin = true
                        SharePref.nama = user!!.data?.nama.toString()
                        SharePref.nohp = user!!.data?.nohp.toString()
                        SharePref.email = user!!.data?.email.toString()
                        SharePref.alamat = user!!.data?.alamat.toString()
                        SharePref.password = user!!.data?.password.toString()

                        val intent = Intent(this@Login,Dashboard::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(this@Login, "Login gagal ${user!!.status.toString()}", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception){
                    Log.e("TAG_ERROR_FAILED_LOGIN", "onResponse: $e" )
                }

            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Toast.makeText(this@Login, "Login gagal $t", Toast.LENGTH_SHORT).show()
                Log.d("TAG_TEST_TEXT3", "onCreate: $t")
            }

        })
    }

}
