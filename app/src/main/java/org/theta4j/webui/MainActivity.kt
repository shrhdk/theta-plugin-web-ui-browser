package org.theta4j.webui

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private val PLUGIN_URL = "http://192.168.1.1:8888";
    }

    private var connManager: ConnectionManager? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connManager = ConnectionManager(applicationContext)

        web_view.settings.javaScriptEnabled = true
        web_view.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                swipe_refresh.isRefreshing = false
            }
        }

        swipe_refresh.setOnRefreshListener { refresh() }

        swipe_refresh.isRefreshing = true
        refresh()
    }

    override fun onDestroy() {
        super.onDestroy()

        connManager?.close()
        connManager = null
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && web_view.canGoBack()) {
            web_view.goBack()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun refresh() {
        web_view.loadUrl(PLUGIN_URL)
    }
}
