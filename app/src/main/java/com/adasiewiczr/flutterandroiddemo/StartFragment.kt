package com.adasiewiczr.flutterandroiddemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.flutter.facade.Flutter
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.StringCodec
import io.flutter.view.FlutterView

class StartFragment : Fragment() {

    private lateinit var sampleBasicMessageChannel: BasicMessageChannel<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = Flutter.createView(activity!!, lifecycle, "/")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sampleBasicMessageChannel = BasicMessageChannel<String>(view as FlutterView, "sample", StringCodec.INSTANCE)
        MethodChannel(view as FlutterView, CHANNEL).setMethodCallHandler { call, result ->
            when {
                call.method == "getMessage" -> result.success("Hello from native")
                call.method == "backPressed" -> activity!!.onBackPressed()
                else -> result.error("Missing implementation", "Missing implementation", null)
            }
        }
    }

    companion object {
        fun newInstance() = StartFragment()

        private const val CHANNEL = "com.adasiewiczr.demo/startPage"
    }
}
