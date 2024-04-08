package com.example.lobby

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // 打開猜數字遊戲
    fun openGuessNumberGame(view: View) {
        val intent = Intent(this, GuessNumberActivity::class.java)
        startActivity(intent)
    }

    // 打開猜拳遊戲
    fun openRockPaperScissorsGame(view: View) {
        val intent = Intent(this, RockPaperScissorsActivity::class.java)
        startActivity(intent)
    }
}