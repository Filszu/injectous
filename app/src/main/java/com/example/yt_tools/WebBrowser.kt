package com.example.yt_tools

//import android.support.v7.app.AppCompatActivity
//import android.support.v7.app.AlertDialog
import android.annotation.SuppressLint
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.yt_tools.databinding.ActivityWebBrowserBinding


class WebBrowser : AppCompatActivity() {

//    var url = "https://ciac.me"
//    var url = "https://google.com"
    var url ="https://www.youtube.com/watch?v=5GLtk2cLRu4"

    private lateinit var binding: ActivityWebBrowserBinding

    @SuppressLint("SetJavaScriptEnabled")

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWebBrowserBinding.inflate(layoutInflater)

        val view = binding.root
        setContentView(view)

        //---------------
        var webView = findViewById<WebView>(R.id.webView1)

        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
//        webView.settings.BuiltInZoomControls=true
//        webView.settings.allowFileAccess=true
        webView.settings.allowContentAccess=true
        webView.settings.javaScriptCanOpenWindowsAutomatically=true
        webView.settings.safeBrowsingEnabled=false
//        webView.settings.domStorageEnabled=true
//        webView.settings.

//        webView.setWebViewClient(object : WebViewClient() {

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                if (Uri.parse(url).host == "www.ciac.me") {
                    // This is my web site, so do not override; let my WebView load the page
                    return false
                } else {
                    //pozniej zmien na pzowolenie
                    return false
                }
//

            }

            fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String,
                result: JsResult
            ): Boolean {
                Log.d("alert", message)
                Toast.makeText(application, message, Toast.LENGTH_SHORT).show()
                result.confirm()
                return true
            }


//            final override fun onPermissionRequest(request: PermissionRequest) {
//                request.grant(request.getResources());
//            }

            override fun onPageFinished(view: WebView?, url: String?) {
                injectJs()
                super.onPageFinished(view, url)
            }


    //            fun onJsAlert(
    //                view: WebView?, url: String?, message: String?,
    //                result: JsResult?
    //            ): Boolean {
    //                return if (mDelegate != null) {
    //                    mDelegate.onJsAlert(view, url, message, result)
    //                } else super.onJsAlert(view, url, message, result)
    //            }
    //            override fun onJsAlert(view:WebView, url:String , message:String){
    //                return super.onJsAlert(view, url, message, result);
    //
    //            }


            override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
                super.onReceivedClientCertRequest(view, request)

                Toast.makeText(application,
                    "QQQ", Toast.LENGTH_SHORT).show()
            }


        }



        webView.loadUrl(url)

//        webView.settings.pluginState(webView.settings.ON)
//        webView.settings.pluginState = ON


//        webView.addJavascriptInterface(MainActivity.WebAppInterface(this), "Android")

        webView.addJavascriptInterface(WebAppInterface(this), "Android")

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        // Check if the key event was the Back button and if there's history
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView1.canGoBack()) {
            binding.webView1.goBack()
            return true
        }
        // If it wasn't the Back key or there's no web page history, bubble up to the default
        // system behavior (probably exit the activity)
        return super.onKeyDown(keyCode, event)
    }

    fun injectJs(){
        try {

//            val script1 = readFile(this,"userScripts/hello.js")
//            Toast.makeText(this,
//                "---$script1---", Toast.LENGTH_LONG).show()
//
//
//            binding.webView1.loadUrl(
//                """javascript:(function f() {
//                    """+script3+"""
//                 })()"""
//            )

            var scriptSrcUrl= "https://ciac.me/scripts/FSa.js"
//            scriptSrcUrl="https://ciac.me/scripts/inj/1.js"
//            scriptSrcUrl="https://ciac.me/scripts/inj/3.js"
//            scriptSrcUrl="https://ciac.me/scripts/inj/yt18.js"

//

            val jsToInj =  """
                            |var script = document.createElement("script");
                            |script.src="$scriptSrcUrl";
                            |document.head.appendChild(script);
                            |""".trimMargin()

//            val script1 = readFile(this,"userScripts/main.js")
//            val jsToInj = "$script1"

            binding.webView1.loadUrl(
                "javascript:(function() {try {$jsToInj;Android.successLoadScript()}catch(err){Android.errInScript(err.stack);}})()"
            )


//            binding.webView1.loadUrl(
//                "javascript:(function() {$jsToInj})()"
//            )


//            binding.webView1.loadUrl(
//                "javascript:(function() {try {$jsToInj; Android.errInScript('inApp')}catch(err){Android.errInScript(err);}})()"
//            )


//            binding.webView1.loadUrl(
//                "javascript:(function() {" +
//                        """
//                            |var script = document.createElement("script");
//                            |script.src="https://ciac.me/scripts/FSa.js";
//                            |document.head.appendChild(script);
//                            |""".trimMargin() +
//                        "})()"
//            )

//            script.src="https://ciac.me/scripts/FSa.js"
//
//            script.innerHTML = "document.write('zzzz')";


//            binding.webView1.loadUrl("alert('hello')")

            Toast.makeText(this,
                "succes fun", Toast.LENGTH_SHORT).show()


        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this,
                "fail", Toast.LENGTH_SHORT).show()
        }
    }
}