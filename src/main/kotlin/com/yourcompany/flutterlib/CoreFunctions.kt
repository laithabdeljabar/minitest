package com.yourcompany.flutterlib

class CoreFunctions {
    
    fun processText(input: String): String {
        return input.uppercase().trim()
    }
    
    fun calculateSum(numbers: List<Int>): Int {
        return numbers.sum()
    }
    
    fun validateEmail(email: String): Boolean {
        val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
        return email.matches(emailRegex.toRegex())
    }
}

