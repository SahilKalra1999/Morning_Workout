package com.sahilkalra.morningworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AbsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abs)
        title="Abs Exercises"
    }
}