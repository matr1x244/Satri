package com.example.satri

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.satri.ui.sign.FragmentSignIn

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main_activity_container, FragmentSignIn.newInstance())
                .commitNow()
        }
    }
}