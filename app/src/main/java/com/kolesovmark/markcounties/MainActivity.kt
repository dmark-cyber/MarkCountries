package com.kolesovmark.markcounties

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.kolesovmark.markcounties.databinding.ActivityMainBinding
import com.kolesovmark.markcounties.databinding.MyFragmentBinding
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
        if (savedInstanceState == null) {
            supportFragmentManager
                .commit {
                setReorderingAllowed(true)
                add<MyFragment>(R.id.fragment_container_view)
                var fragmentBinding = MyFragmentBinding.inflate(layoutInflater)
                fragmentBinding.buttonToast.setOnClickListener {
                    Toast.makeText(
                        this@MainActivity,
                        "Clicked",
                        Toast.LENGTH_LONG
                    ).show()
                }
                fragmentBinding.radioToast.setOnCheckedChangeListener { compoundButton, b ->
                    if (b) {
                        Toast.makeText(
                            this@MainActivity,
                            "Clicked Radio",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
                fragmentBinding.switchToast.setOnCheckedChangeListener { compoundButton, b ->
                    if (b) {
                        Toast.makeText(
                            this@MainActivity,
                            "Clicked Switch",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

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
            "${((timeOnRestart - timeOnStop) * 1e-9)} секунд",
            Toast.LENGTH_LONG
        ).show()
    }
}