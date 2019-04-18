package com.example.bgs_app

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Point
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.ShareCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private val imageUrl = "https://pp.userapi.com/c851320/v851320228/100ca9/OQpt_reGU9I.jpg"
    private val okClient by lazy{
        OkHttpClient()
    }
    private val okRequest by lazy {
        Request.Builder()
            .url(imageUrl)
            .build()

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            imageView.setImageResource(android.R.color.transparent)
            setImageViewDimensions()
            loadimage()
        }
    }

    private fun loadimage(){
        okClient.newCall(okRequest).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                val inputStream = response.body()?.byteStream()
                val bitmap = BitmapFactory.decodeStream(inputStream)
                runOnUiThread {
                    imageView.setImageBitmap(bitmap)
                }
            }

        })
    }

    private fun setImageViewDimensions() {
        val aspectRatio = 2.toFloat() / 3.toFloat()
        val screenDimensions = Point()
        windowManager.defaultDisplay.getSize(screenDimensions)
        val imageViewWidth = screenDimensions.x
        val imageViewHeight = (screenDimensions.x * aspectRatio).toInt()
        val params = ConstraintLayout.LayoutParams(imageViewWidth, imageViewHeight)
        imageView.layoutParams = params
    }

    fun cont (view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
    }
}
