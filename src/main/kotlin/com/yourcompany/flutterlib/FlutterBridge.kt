package com.yourcompany.flutterlib

class FlutterBridge {
    private val coreFunctions = CoreFunctions()
    private val dataProcessor = DataProcessor()
    private val networkHelper = NetworkHelper()
    
    // Method Channel compatible methods
    fun executeFunction(functionName: String, parameters: Map<String, Any>): Map<String, Any> {
        return try {
            when (functionName) {
                "processText" -> {
                    val input = parameters["input"] as? String ?: ""
                    val result = coreFunctions.processText(input)
                    mapOf("success" to true, "result" to result)
                }
                "calculateSum" -> {
                    @Suppress("UNCHECKED_CAST")
                    val numbers = (parameters["numbers"] as? List<*> ?: emptyList<Any>()) as List<Int>
                    val result = coreFunctions.calculateSum(numbers)
                    mapOf("success" to true, "result" to result)
                }
                "validateEmail" -> {
                    val email = parameters["email"] as? String ?: ""
                    val result = coreFunctions.validateEmail(email)
                    mapOf("success" to true, "result" to result)
                }
                "parseJson" -> {
                    val json = parameters["json"] as? String ?: ""
                    val result: Map<String, Any>? = dataProcessor.fromJson<Map<String, Any>>(json)
                    mapOf("success" to true, "result" to (result ?: emptyMap<String, Any>()))
                }
                else -> mapOf("success" to false, "error" to "Unknown function: $functionName")
            }
        } catch (e: Exception) {
            mapOf("success" to false, "error" to (e.message ?: "Unknown error"))
        }
    }
}

