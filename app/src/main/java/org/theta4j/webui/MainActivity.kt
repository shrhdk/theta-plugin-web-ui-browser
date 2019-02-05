/*
 * Copyright (C) 2019 Hideki Shiro
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
        private val INITIAL_URL = "file:///android_asset/initial_view.html"
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
                if (web_view.url == INITIAL_URL) {
                    swipe_refresh.isRefreshing = true
                    refresh()
                } else {
                    super.onPageFinished(view, url)
                    swipe_refresh.isRefreshing = false
                }
            }
        }
        web_view.loadUrl(INITIAL_URL)

        swipe_refresh.setOnRefreshListener { refresh() }
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
