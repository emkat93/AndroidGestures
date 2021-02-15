package com.example.androidgestures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null
    lateinit var  srl: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        getGestureText.text = "onDown"
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        getGestureText.text = "onShowPress"
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        getGestureText.text = "onSingleTapUp"
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent?,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        getGestureText.text = "onScroll"
        //Handler().postDelayed(Runnable {
        //    srl.isRefreshing = false
        //}, 4000)

        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        getGestureText.text = "onLongPress"
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent?,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        getGestureText.text = "onFLing"
        var intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        getGestureText.text = "onSingleTapConfirmed"
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        getGestureText.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        getGestureText.text = "onDoubleTapEvent"
        return true
    }
}