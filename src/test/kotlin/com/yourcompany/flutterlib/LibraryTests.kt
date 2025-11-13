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
    
    @Test
    fun testHomeScreenManager() {
        val manager = HomeScreenManager()
        val homeScreen = manager.createDefaultHomeScreen()
        assertEquals("Welcome", homeScreen.title)
        assertTrue(homeScreen.items.isNotEmpty())
    }
    
    @Test
    fun testHomeScreenToJson() {
        val manager = HomeScreenManager()
        val homeScreen = manager.createDefaultHomeScreen()
        val json = manager.homeScreenToJson(homeScreen)
        assertTrue(json.isNotEmpty())
        assertTrue(json.contains("Welcome"))
    }
    
    @Test
    fun testHomeScreenFromJson() {
        val manager = HomeScreenManager()
        val homeScreen = manager.createDefaultHomeScreen()
        val json = manager.homeScreenToJson(homeScreen)
        val parsed = manager.createHomeScreenFromJson(json)
        assertTrue(parsed != null)
        if (parsed != null) {
            assertEquals(homeScreen.title, parsed.title)
        }
    }
    
    @Test
    fun testFlutterBridgeHomeScreen() {
        val bridge = FlutterBridge()
        val result = bridge.executeFunction("createHomeScreen", emptyMap())
        assertEquals(true, result["success"])
        val screenData = result["result"] as? Map<*, *>
        assertTrue(screenData != null)
        if (screenData != null) {
            assertEquals("Welcome", screenData["title"])
        }
    }
}

