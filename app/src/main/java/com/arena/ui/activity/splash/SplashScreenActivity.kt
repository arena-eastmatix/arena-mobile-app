package com.arena.ui.activity.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.arena.R
import com.arena.data.source.local.SharedPreferencesManager
import com.arena.ui.activity.auth.AuthActivity
import com.arena.ui.activity.user.UserActivity


class SplashScreenActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        prefs = SharedPreferencesManager(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (prefs.getToken() != null) {
                startActivity(Intent(this, UserActivity::class.java))
            } else {
                startActivity(Intent(this, AuthActivity::class.java))
            }
            finish()
        }, 2000)
    }
}
