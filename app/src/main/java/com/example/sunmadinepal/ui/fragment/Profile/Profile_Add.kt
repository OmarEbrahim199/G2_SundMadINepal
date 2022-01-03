package com.example.sunmadinepal.ui.fragment.Profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunmadinepal.R
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*


class profile_Add : AppCompatActivity() {

    lateinit var t1: TextToSpeech
    //var fileName = "src/main/assets/Recipes/recipes_for_pregant_woman/recipes_for_pregant_woman.html"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_add)


        t1 = TextToSpeech(applicationContext,TextToSpeech.OnInitListener { status ->
            if (status !=TextToSpeech.ERROR) {
                t1.language = Locale.US
            }
        })

        val button: Button = findViewById(R.id.speakbt1)
       val textto: TextView = findViewById(R.id.texttospeak)

        button.setOnClickListener {

          val toSpeak = textto.text.toString()
            Toast.makeText(this,toSpeak,Toast.LENGTH_SHORT).show()
            t1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH,null)

        }


    }



}