package com.kolesovmark.markcounties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kolesovmark.markcounties.databinding.ActivityMainBinding
import kotlin.time.Duration.Companion.seconds

// показать, сколько секунд приложение было свернуто
// в toast
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var timeOnStop: Long = 0
    private var timeOnRestart: Long = 0
    //private var timer = Timer(1000000, 1000)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Toast.makeText(
            this,
            "OnCreate",
            Toast.LENGTH_LONG).show()

    }
    override fun onStop() {
        super.onStop()

        timeOnStop = System.nanoTime()
    }

    override fun onRestart() {
        super.onRestart()
        timeOnRestart = System.nanoTime()
        Toast.makeText(
            this,
            "OnRestart",
            Toast.LENGTH_LONG).show()
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(
            this,
            "${((timeOnRestart - timeOnStop)*1e-9).seconds}",
            Toast.LENGTH_LONG).show()
    }
//    private class Timer(val mills: Long, val interval: Long) : CountDownTimer(mills, interval) {
//        override fun onTick(p0: Long) {
//
//        }
//
//        override fun onFinish() {
//
//        }
//    }
}