package com.example.yt_tools

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

/** Instantiate the interface and set the context  */
class WebAppInterface(private val mContext: Context) {
    /** Show a toast from the web page  */
    @JavascriptInterface
    fun showToast(toast: String) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show()
    }

    @JavascriptInterface
    fun errInScript(err: String) {
        Toast.makeText(mContext, "Error in your script occurred:\n" +
                "$err", Toast.LENGTH_LONG).show()
//        showToast("Error in your script occurred:\n$err")
    }

    @JavascriptInterface
    fun successLoadScript() {
//        showToast("succes")
    }

}