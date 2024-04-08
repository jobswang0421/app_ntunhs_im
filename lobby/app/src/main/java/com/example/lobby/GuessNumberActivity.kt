package com.example.lobby

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import android.content.Intent

class GuessNumberActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private var big_num = 100
    private var small_num = 0
    private var secret = Random().nextInt(100) + 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gn)

        handler = Handler(Looper.getMainLooper())

        val textView: TextView = findViewById(R.id.textView)
        val guessButton: Button = findViewById(R.id.guess_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        val editText: EditText = findViewById(R.id.editText)
        val bkBtn: Button = findViewById(R.id.bkBtn)

        // 為按鈕設置點擊監聽器
        bkBtn.setOnClickListener {
            // 創建一個意圖，從當前 Activity 跳轉到 LobbyActivity
            val intent = Intent(this@GuessNumberActivity, MainActivity::class.java)
            startActivity(intent)

            // 如果您不希望從「大廳」返回到這個 Activity，可以在跳轉後結束當前 Activity
            finish()
        }

        guessButton.setOnClickListener {
            val input = editText.text.toString()
            val gs = input.toIntOrNull()

            if (gs == null || gs == 0) {
                textView.text = getString(R.string.please_enter_a_number)
                editText.text.clear()
                return@setOnClickListener
            }

            val validateNum = gs - secret

            when {
                validateNum == 0 -> {
                    textView.text = getString(R.string.correct)
                    // 立即顯示贏了的 Toast 提示
                    Toast.makeText(this, getString(R.string.reset_game_mention), Toast.LENGTH_SHORT).show()
                    // 6秒後延遲執行resetGame，而不是立即重置
                    handler.postDelayed({
                        resetGame()
                    }, 6000)
                }
                validateNum > 0 -> {
                    big_num = Math.min(gs, big_num)
                    textView.text = getString(R.string.too_big_range, small_num, big_num)
                }
                else -> {
                    small_num = Math.max(gs, small_num)
                    textView.text = getString(R.string.too_small_range, small_num, big_num)
                }
            }
        }

        resetButton.setOnClickListener {
            resetGame()
        }

    }

    private fun resetGame() {
        secret = Random().nextInt(100) + 1
        big_num = 100
        small_num = 0
        findViewById<TextView>(R.id.textView).text = getString(R.string.let_us_guess_again)
        findViewById<EditText>(R.id.editText).text.clear()
    }

}