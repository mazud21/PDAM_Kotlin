package com.hmazud.pdam_kotlin.View

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.hmazud.pdam_kotlin.Local.SharePref
import com.hmazud.pdam_kotlin.R

class Dashboard : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnInfoMasalah = findViewById<Button>(R.id.btnInfoMasalah)

        val txNama = findViewById<TextView>(R.id.txNama)
        val txNoHp = findViewById<TextView>(R.id.txNoHp)
        val txEmail = findViewById<TextView>(R.id.txEmail)

        val btnLogout = findViewById<Button>(R.id.btnLogout)

        SharePref.init(this)

        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        txNama.text = SharePref.nama
        txNoHp.text = SharePref.nohp
        txEmail.text = SharePref.email

        btnLogout.setOnClickListener(View.OnClickListener {
            SharePref.isLogin = false
            editor.remove("IS_LOGIN")
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        })

        btnInfoMasalah.setOnClickListener {
            val intent = Intent(this, InfoMasalah::class.java)
            startActivity(intent)
        }
    }
}