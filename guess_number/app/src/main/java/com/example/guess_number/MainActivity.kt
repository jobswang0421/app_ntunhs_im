package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val guess_button = findViewById<Button>(R.id.guess_button)
        val reset_button = findViewById<Button>(R.id.reset_button)
        val editText = findViewById<EditText>(R.id.editText)
        var validate_num: Int=0
        var big_num:Int=100
        var small_num:Int=0
        var secret: Int = Random().nextInt(100) + 1

        guess_button.setOnClickListener {
            textView.text = editText.text

            validate_num = editText.text.toString().toInt() - secret
            var ans_str: String = "CORRECT"

            if (validate_num > 0) {
                big_num=editText.text.toString().toInt()
                ans_str = "TOO BIG, RANGE: $small_num-$big_num"
            } else if (validate_num < 0) {
                small_num=editText.text.toString().toInt()
                ans_str = "TOO SMALL, RANGE: $small_num-$big_num"
            }
            textView.text = ans_str

        }
        reset_button.setOnClickListener {
            secret = Random().nextInt(100) + 1
            textView.text = "LET US GUESS AGAIN!"
        }

    }

}





