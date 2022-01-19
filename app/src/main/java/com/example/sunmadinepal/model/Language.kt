package com.example.sunmadinepal.model

import android.content.Context
import android.content.res.Configuration
import java.util.*


fun setLocale(c:Context,code: String) {

    val locale = Locale(code)
    Locale.setDefault(locale)
    val config = Configuration()
    config.locale = locale
    c.getApplicationContext().resources.updateConfiguration(config, null)


}