package com.adasiewiczr.flutterandroiddemo

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.flutter.facade.Flutter
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
        inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        openFirstFragmentButton.setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentContainer, Flutter.createFragment("second"))
                .addToBackStack(null)
                .commit()
        }

        openFragmentButton.setOnClickListener {
            fragmentManager!!.beginTransaction()
                .replace(R.id.fragmentContainer, StartFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

        openAnimationView.setOnClickListener {
            startActivity(Intent(context, SecondActivity::class.java))
        }
    }
}
