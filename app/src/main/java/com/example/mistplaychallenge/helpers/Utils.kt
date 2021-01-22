package com.example.mistplaychallenge.helpers

import android.content.Context
import android.util.Log
import java.io.IOException

class Utils {
    fun getJsonFromAsset(context: Context, filename: String): String? {
        var jsonString: String ?=null
        try{
           jsonString = context.assets
                   .open(filename)
                   .bufferedReader()
                   .use { it.readText() }
        }catch (ioException: IOException){
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}