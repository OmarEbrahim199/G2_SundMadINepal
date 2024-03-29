package com.example.sunmadinepal

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

import com.example.sunmadinepal.databinding.ActivityNavigationBinding
import java.util.*


class Navigation() : AppCompatActivity() {


    private lateinit var binding: ActivityNavigationBinding


    override fun onStart() {
        super.onStart()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = this.resources.getColor(R.color.Orange)
            window.navigationBarColor = this.resources.getColor(R.color.Orange)
        }


        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_navigation)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_profile,R.id.navigation_health, R.id.navigation_recipes,R.id.navigation_garden,
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


        val actionBar = supportActionBar
        actionBar!!.title = resources.getString(R.string.app_name)
        actionBar.setHomeButtonEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    // This mothed used in OnClick in Home XML
    public fun getLanguage(view: View) {
        loadLocate()
        showChangeLang()
    }

     fun showChangeLang() {

        val text: TextView = findViewById(R.id.Choose_Language)

        val listItmes = arrayOf( "नेपाली", "English")
         val string = Locale.getDefault().getLanguage()
         var checkedLanguage = 1

         if (
             string.equals("ne")
         ) {checkedLanguage = 0
         }
         else if (
             string.equals("en")
         ) {checkedLanguage = 1
         }

        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setTitle(text.text)
        mBuilder.setSingleChoiceItems(listItmes, checkedLanguage) { dialog, which ->
            if (which == 0) {
                setLocate("ne")
                recreate()
            } else if (which == 1) {
                setLocate("en")
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

    public fun loadLocate() {
        val sharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language = sharedPreferences.getString("My_Lang", "")
        language?.let { setLocate(it) }
    }


















}