package com.example.mistplaychallenge.helpers

import android.content.Context
import android.util.Log
import java.io.IOException

class Utils {
    /**
     * Returns json string for the filename specified,
     * file should be placed in assets folder.
     */
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