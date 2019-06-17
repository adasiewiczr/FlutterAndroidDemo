package com.adasiewiczr.flutterandroiddemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import io.flutter.facade.Flutter
import org.jetbrains.anko.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = Flutter.createView(this, lifecycle, "animation")
        SecondActivityUI(view).setContentView(this)
    }
}

class SecondActivityUI(private val additionalView: View) : AnkoComponent<SecondActivity> {
    override fun createView(ui: AnkoContext<SecondActivity>) = with(ui) {
        verticalLayout {
            textView("Hello from native").lparams {
                margin = dip(16)
            }
            addView(additionalView)
        }
    }
}

