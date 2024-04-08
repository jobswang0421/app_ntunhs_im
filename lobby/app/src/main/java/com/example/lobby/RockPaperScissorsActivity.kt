package com.example.lobby

import android.content.Intent
import android.os.Bundle
import android.widget.*
import kotlin.random.Random
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class RockPaperScissorsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pss)

        val comView = findViewById<ImageView>(R.id.comView)
        val txtResult = findViewById<TextView>(R.id.txtResult)
        val btnScissors = findViewById<ImageButton>(R.id.btnScissor)
        val btnStone = findViewById<ImageButton>(R.id.btnStone)
        val btnPaper = findViewById<ImageButton>(R.id.btnPaper)
        val bkBtn: Button = findViewById(R.id.bkBtn)

        // 為按鈕設置點擊監聽器
        bkBtn.setOnClickListener {
            // 創建一個意圖，從當前 Activity 跳轉到 LobbyActivity
            val intent = Intent(this@RockPaperScissorsActivity, MainActivity::class.java)
            startActivity(intent)

            // 如果您不希望從「大廳」返回到這個 Activity，可以在跳轉後結束當前 Activity
            finish()
        }

        val playGame = { playerChoice: Int ->
            val iComPlay = Random.nextInt(1, 101)
            txtResult.text = ""
            comView.setImageResource(android.R.color.transparent)

            val (winRange, drawRange) = when(playerChoice) {
                R.id.btnScissor -> Pair(71..100, 41..70)
                R.id.btnStone -> Pair(1..40, 41..70)
                else -> Pair(1..40, 71..100) // Paper
            }

            val result = when (iComPlay) {
                in winRange -> Pair(R.drawable.paper, R.string.win) // Win
                in drawRange -> Pair(R.drawable.scissor, R.string.draw) // Draw
                else -> Pair(R.drawable.stone, R.string.lose) // Lose
            }

            comView.setImageResource(result.first)
            txtResult.setText(result.second)
        }

        btnPaper.setOnClickListener { playGame(R.id.btnPaper) }
        btnScissors.setOnClickListener { playGame(R.id.btnScissor) }
        btnStone.setOnClickListener { playGame(R.id.btnStone) }
    }
}
