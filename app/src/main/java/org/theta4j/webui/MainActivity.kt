package org.theta4j.webui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var connManager: ConnectionManager? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web_view.settings.javaScriptEnabled = true
        refresh_button.setOnClickListener { refresh() }

        connManager = ConnectionManager(applicationContext)
    }

    override fun onDestroy() {
        super.onDestroy()

        connManager?.close()
        connManager = null
    }

    private fun refresh() {
        web_view.loadUrl("http://192.168.1.1:8888")
    }
}
