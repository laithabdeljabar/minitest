package com.yourcompany.flutterlib

data class HomeScreen(
    val title: String = "Home",
    val subtitle: String? = null,
    val items: List<HomeScreenItem> = emptyList(),
    val backgroundColor: String? = null,
    val textColor: String? = null
)

data class HomeScreenItem(
    val id: String,
    val title: String,
    val description: String? = null,
    val icon: String? = null,
    val action: String? = null,
    val metadata: Map<String, Any> = emptyMap()
)

class HomeScreenManager {
    
    fun createDefaultHomeScreen(): HomeScreen {
        return HomeScreen(
            title = "Welcome",
            subtitle = "Your Flutter Kotlin Library",
            items = listOf(
                HomeScreenItem(
                    id = "1",
                    title = "Core Functions",
                    description = "Text processing and calculations",
                    icon = "functions",
                    action = "navigate://core"
                ),
                HomeScreenItem(
                    id = "2",
                    title = "Data Processing",
                    description = "JSON parsing and data transformation",
                    icon = "data",
                    action = "navigate://data"
                ),
                HomeScreenItem(
                    id = "3",
                    title = "Network Helper",
                    description = "HTTP requests and network operations",
                    icon = "network",
                    action = "navigate://network"
                )
            )
        )
    }
    
    fun createHomeScreenFromJson(json: String): HomeScreen? {
        return try {
            val dataProcessor = DataProcessor()
            val map: Map<String, Any>? = dataProcessor.fromJson(json)
            map?.let { createHomeScreenFromMap(it) }
        } catch (e: Exception) {
            null
        }
    }
    
    fun createHomeScreenFromMap(data: Map<String, Any>): HomeScreen {
        val items = (data["items"] as? List<*>)?.mapNotNull { item ->
            if (item is Map<*, *>) {
                @Suppress("UNCHECKED_CAST")
                val itemMap = item as Map<String, Any>
                HomeScreenItem(
                    id = itemMap["id"] as? String ?: "",
                    title = itemMap["title"] as? String ?: "",
                    description = itemMap["description"] as? String,
                    icon = itemMap["icon"] as? String,
                    action = itemMap["action"] as? String,
                    metadata = (itemMap["metadata"] as? Map<*, *>)?.let {
                        @Suppress("UNCHECKED_CAST")
                        it as Map<String, Any>
                    } ?: emptyMap()
                )
            } else {
                null
            }
        } ?: emptyList()
        
        return HomeScreen(
            title = data["title"] as? String ?: "Home",
            subtitle = data["subtitle"] as? String,
            items = items,
            backgroundColor = data["backgroundColor"] as? String,
            textColor = data["textColor"] as? String
        )
    }
    
    fun homeScreenToJson(homeScreen: HomeScreen): String {
        val dataProcessor = DataProcessor()
        val map = mapOf(
            "title" to homeScreen.title,
            "subtitle" to homeScreen.subtitle,
            "items" to homeScreen.items.map { item ->
                mapOf(
                    "id" to item.id,
                    "title" to item.title,
                    "description" to item.description,
                    "icon" to item.icon,
                    "action" to item.action,
                    "metadata" to item.metadata
                )
            },
            "backgroundColor" to homeScreen.backgroundColor,
            "textColor" to homeScreen.textColor
        )
        return dataProcessor.toJson(map)
    }
    
    fun homeScreenToMap(homeScreen: HomeScreen): Map<String, Any> {
        return mapOf(
            "title" to homeScreen.title,
            "subtitle" to (homeScreen.subtitle ?: ""),
            "items" to homeScreen.items.map { item ->
                mapOf(
                    "id" to item.id,
                    "title" to item.title,
                    "description" to (item.description ?: ""),
                    "icon" to (item.icon ?: ""),
                    "action" to (item.action ?: ""),
                    "metadata" to item.metadata
                )
            },
            "backgroundColor" to (homeScreen.backgroundColor ?: ""),
            "textColor" to (homeScreen.textColor ?: "")
        )
    }
}

