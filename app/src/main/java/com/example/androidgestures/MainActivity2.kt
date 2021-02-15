package com.example.androidgestures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        this.gDetector?.onTouchEvent(event)
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent?): Boolean {
        result.text = "$count"
        return true
    }

    override fun onShowPress(e: MotionEvent?) {
        result.text = "$count"
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        count += 1
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        result.text = "$count"
        return true
    }

    override fun onLongPress(e: MotionEvent?) {
        result.text = "$count"
    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        var intent2 = Intent(this, MainActivity::class.java)
        startActivity(intent2)
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        result.text = "$count"
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        count += 2
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        result.text = "$count"
        return true
    }
}