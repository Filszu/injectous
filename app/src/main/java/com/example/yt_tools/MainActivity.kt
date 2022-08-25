package com.example.yt_tools

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Base64
import android.view.KeyEvent
import android.view.View
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebSettings.PluginState.ON
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {



    private lateinit var webView: WebView
    private var urlEdit: EditText? = null
    var url = "https://ciac.me"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val intent = Intent(this, WebBrowser::class.java)


        startActivity(intent)
    }}
//
//
//
//
//        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
//
//
//        urlEdit = findViewById(R.id.te_url)
//
//
//        webView= findViewById(R.id.webView1)
//
//        webView.setWebViewClient(object : WebViewClient() {
//            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
//                return false
//            }
//        })
//
//
//        webView.settings.javaScriptEnabled = true
//        webView.settings.javaScriptCanOpenWindowsAutomatically = true
//
//        webView.loadUrl("https://www.google.com/")
//
////        webView.settings.pluginState(webView.settings.ON)
////        webView.settings.pluginState = ON
//
//
//        webView.addJavascriptInterface(WebAppInterface(this), "Android")
//
//
//
//
//
//    }
//
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//        if(webView.canGoBack()){
//            webView.goBack()
//        }
//        else{
//            super.onBackPressed()
//        }
//    }
//
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        // Check if the key event was the Back button and if there's history
//        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
//            webView.goBack()
//            return true
//        }
//        // If it wasn't the Back key or there's no web page history, bubble up to the default
//        // system behavior (probably exit the activity)
//        return super.onKeyDown(keyCode, event)
//    }
//
//
//    /** Instantiate the interface and set the context  */
//    class WebAppInterface(private val mContext: Context) {
//        /** Show a toast from the web page  */
//        @JavascriptInterface
//        fun showToast(toast: String) {
//            Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//
//    fun changeUrl(view: View) {
//
//
//
//        url = urlEdit?.text.toString()
//
//        Toast.makeText(this,
//            url, Toast.LENGTH_LONG).show()
//
//        webView.loadUrl(url)
//
//
//    }
//
//    fun customHTML(view: View) {
//
//        // Create an unencoded HTML string
//        // then convert the unencoded HTML string into bytes, encode
//        // it with Base64, and load the data.
//        val unencodedHtml =
//            """<html><body><h1>Hello</h1> </body></html>
//
//                <script type="text/javascript">
//                    function showAndroidToast(toast) {
//                        Android.showToast(toast);
//                    }
//                    showAndroidToast("kkk")
//                </script>
//            """.trimMargin();
//        val encodedHtml = Base64.encodeToString(unencodedHtml.toByteArray(), Base64.NO_PADDING)
//        webView.loadData(encodedHtml, "text/html", "base64")
//
//    }
//
//
//}