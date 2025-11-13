package com.yourcompany.flutterlib

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LibraryTests {
    
    @Test
    fun testProcessText() {
        val core = CoreFunctions()
        assertEquals("HELLO", core.processText("  hello  "))
    }
    
    @Test
    fun testCalculateSum() {
        val core = CoreFunctions()
        assertEquals(15, core.calculateSum(listOf(1, 2, 3, 4, 5)))
    }
    
    @Test
    fun testValidateEmail() {
        val core = CoreFunctions()
        assertTrue(core.validateEmail("test@example.com"))
        assertFalse(core.validateEmail("invalid-email"))
    }
    
    @Test
    fun testFlutterBridge() {
        val bridge = FlutterBridge()
        val result = bridge.executeFunction("processText", mapOf("input" to " test "))
        assertEquals(true, result["success"])
        assertEquals("TEST", result["result"])
    }
}

