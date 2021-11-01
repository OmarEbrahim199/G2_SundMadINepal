package com.example.sunmadinepal

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.*
import com.example.sunmadinepal.ui.Profile.profile_Add
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        LogoStart()

    }

    private fun LogoStart() {

        val splashThread: Thread = object : Thread() {
            override fun run() {
                try {
                    var waited = 0
                    rotatLogo()
                    while (waited < 3000) {
                        sleep(100)
                        waited += 100
                    }
                } catch (e: InterruptedException) {
                    // do nothing
                } finally {
                    finish()
                    val i = Intent(this@MainActivity, Navigation::class.java)
                    startActivity(i)
                }
            }
        }
        splashThread.start()
    }


    private fun rotatLogo() {

        var degree = 0
        var degreeOld= 0

        val RANDOM = Random()

        val image: ImageView = findViewById(R.id.loding_icon_1)

        degreeOld = degree % 360
        // we calculate random angle for rotation of our wheel
        degree = RANDOM.nextInt(360) + 720
        // rotation effect on the center of the wheel
        val rotateAnim = RotateAnimation(
            degreeOld.toFloat(), degree.toFloat(),
            RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnim.duration = 2600
        rotateAnim.repeatCount =2
        rotateAnim.fillAfter = true
        rotateAnim.interpolator = DecelerateInterpolator()
        rotateAnim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                // we empty the result text view when the animation start

            }

            override fun onAnimationEnd(animation: Animation) {
                // we display the correct sector pointed by the triangle at the end of the rotate animation
                //resultTv.text = getSector(360 - degree % 360)

            }

            override fun onAnimationRepeat(animation: Animation) {

            }

        })

        // we start the animation
        image.startAnimation(rotateAnim)

    }






}




