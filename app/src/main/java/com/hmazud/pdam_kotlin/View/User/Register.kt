package com.hmazud.pdam_kotlin.View.User

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import com.hmazud.pdam_kotlin.R

class Register : AppCompatActivity() {

    val REQUEST_CODE = 200

    fun capturePhoto() {

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, REQUEST_CODE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        var imgKtp = findViewById<ImageView>(R.id.imgKtp)
        var btnKtp = findViewById<Button>(R.id.btnKtp)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE && data != null){
            //btnKtp.setImageBitmap(data.extras?.get("data") as Bitmap)
        }
    }
}