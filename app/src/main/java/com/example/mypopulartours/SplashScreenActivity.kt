package com.example.mypopulartours

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.*

class SplashScreenActivity : AppCompatActivity() {
    private val splashTimeOut: Long = 2000
    private lateinit var imgSplash: View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        imgSplash = findViewById(R.id.img_splash)

        imgSplash.alpha = 0f
        imgSplash.animate().setDuration(1500).alpha(1f).start()

        Handler().postDelayed({
            val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }

}