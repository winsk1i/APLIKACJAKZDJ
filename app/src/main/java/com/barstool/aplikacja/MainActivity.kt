package com.barstool.aplikacja

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageSwitcher
import android.widget.ImageView
import android.widget.TextView
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val koty = intArrayOf(R.drawable.kot1,
        R.drawable.kot2, R.drawable.kot3)
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgSwitcher = findViewById<ImageSwitcher>(R.id.imgswitch)

        imgSwitcher?.setFactory({
            val imgView = ImageView(applicationContext)
            imgView.scaleType = ImageView.ScaleType.FIT_CENTER
            imgView.setPadding(8, 8, 8, 8)
            imgView
        })

        imgSwitcher?.setImageResource(koty[index])

        val imgIn = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_in_left)
        imgSwitcher?.inAnimation = imgIn

        val imgOut = AnimationUtils.loadAnimation(
            this, android.R.anim.slide_out_right)
        imgSwitcher?.outAnimation = imgOut

        val prev = findViewById<Button>(R.id.wstecz)
        prev.setOnClickListener {
            index = if (index - 1 >= 0) index - 1 else 2
            imgSwitcher?.setImageResource(koty[index])
        }

        val next = findViewById<Button>(R.id.dalej)
        next.setOnClickListener {
            index = if (index + 1 < koty.size) index +1 else 0
            imgSwitcher?.setImageResource(koty[index])

            val silniaRun=findViewById<Button>(R.id.button3)
            val silniaInput=findViewById<EditText>(R.id.wpisz)

            silniaRun.setOnClickListener {
                val inputInt = silniaInput.text.toString().toInt()
                var liczbaZSilni=1
                if(inputInt==0 || inputInt==1){
                    liczbaZSilni=1
                }
                else{
                    for(i in 2 .. inputInt)
                        liczbaZSilni*=i
                }
                val text = liczbaZSilni.toString()
                findViewById<TextView>(R.id.wynik).text=(text)
            }

        }
    }
}