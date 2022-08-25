package com.example.yt_tools

import android.content.Context
import java.io.IOException

fun readFile(context: Context, fileName: String): String? {
    val fileString: String
    try {
        fileString = context.assets.open(fileName).bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return "File read error => check out avaible scripts here www.inj.ciac.me"
    }
    finally {
//        close
    }
    return fileString
}



