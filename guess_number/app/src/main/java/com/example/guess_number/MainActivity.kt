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
        var validate_num: Int
        var big_num:Int=100
        var small_num:Int=0
        var secret: Int = Random().nextInt(100) + 1
        var gs: Int
        guess_button.setOnClickListener {
            textView.text = editText.text
            if (editText.text.isNotEmpty()) {
                gs = editText.text.toString().toInt()
            }else{
                gs =0
            }
            validate_num = gs - secret
            var ans_str: String = "CORRECT"

            if (gs == 0) {
                ans_str ="PLEASE ENTER A NUMBER"
            } else if (validate_num == 0) {
                ans_str = "CORRECT"
            }else if (validate_num > 0) {
                if (big_num<gs){
                    big_num=big_num
                }else{
                    big_num=gs
                }
                ans_str = "TOO BIG, RANGE: $small_num-$big_num"
            }else {
                if (small_num>gs){
                    small_num=small_num
                }else{
                    small_num=gs
                }
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





