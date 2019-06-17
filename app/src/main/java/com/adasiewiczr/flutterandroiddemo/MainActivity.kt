package com.adasiewiczr.flutterandroiddemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.flutter.facade.Flutter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Flutter.startInitialization(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, MainFragment.newInstance())
            .commit()
    }
}
