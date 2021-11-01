package com.example.sunmadinepal.language

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.sunmadinepal.Navigation
import com.example.sunmadinepal.R
import com.example.sunmadinepal.ui.Profile.profile_Add
import java.util.*

class Language : AppCompatActivity() {

    lateinit var mBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //loadLocate()
       // showChangeLang()
        setContentView(R.layout.activity_language)

     
    }



    fun showChangeLang() {

        val listItmes = arrayOf("عربي", "हिंदी", "اردو", "English","Danish")

        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle("Choose Language")
        mBuilder.setView(-1)
        mBuilder.setSingleChoiceItems(listItmes, -1) { dialog, which ->
            if (which == 0) {
                setLocate("ar")
                recreate()
            } else if (which == 1) {
                setLocate("hi")
                recreate()
            } else if (which == 2) {
                setLocate("ur")
                recreate()
            } else if (which == 3) {
                setLocate("en")
                recreate()
            }else if (which == 4) {
                setLocate("da")
                recreate()
            }

            dialog.dismiss()
        }
        val mDialog = mBuilder.create()

        mDialog.show()

    }
    fun setLocate(Lang: String) {

        val locale = Locale(Lang)

        Locale.setDefault(locale)

        val config = Configuration()

        config.locale = locale
        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

        val editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang", Lang)
        editor.apply()
    }

    fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        language?.let { setLocate(it) }
    }



}



