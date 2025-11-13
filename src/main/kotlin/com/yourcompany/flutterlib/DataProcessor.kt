package com.yourcompany.flutterlib

import com.google.gson.Gson

class DataProcessor {
    val gson = Gson()
    
    inline fun <reified T> fromJson(json: String): T? {
        return try {
            gson.fromJson(json, T::class.java)
        } catch (e: Exception) {
            null
        }
    }
    
    fun toJson(obj: Any): String {
        return gson.toJson(obj)
    }
    
    fun processMap(data: Map<String, Any>): Map<String, Any> {
        return data.mapValues { (_, value) ->
            when (value) {
                is String -> value.trim()
                is Number -> value
                else -> value.toString()
            }
        }
    }
}

