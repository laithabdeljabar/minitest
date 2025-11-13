# Flutter Kotlin Library

A Kotlin library designed for Flutter projects, providing core functionality for text processing, data manipulation, network operations, and Flutter bridge integration.

## Features

- **CoreFunctions**: Text processing, calculations, and email validation
- **DataProcessor**: JSON parsing and data transformation using Gson
- **NetworkHelper**: HTTP client operations using OkHttp
- **FlutterBridge**: Method channel compatible bridge for Flutter integration

## Installation

### Gradle

Add the following to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.yourcompany:flutter-kotlin-lib:1.0.0")
}
```

### Maven

```xml
<dependency>
    <groupId>com.yourcompany</groupId>
    <artifactId>flutter-kotlin-lib</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Usage

### Core Functions

```kotlin
import com.yourcompany.flutterlib.CoreFunctions

val core = CoreFunctions()
val processed = core.processText("  hello world  ") // "HELLO WORLD"
val sum = core.calculateSum(listOf(1, 2, 3, 4, 5)) // 15
val isValid = core.validateEmail("test@example.com") // true
```

### Data Processing

```kotlin
import com.yourcompany.flutterlib.DataProcessor

val processor = DataProcessor()
val json = processor.toJson(myObject)
val obj: MyClass? = processor.fromJson<MyClass>(jsonString)
```

### Network Operations

```kotlin
import com.yourcompany.flutterlib.NetworkHelper
import kotlinx.coroutines.runBlocking

val network = NetworkHelper()
runBlocking {
    val response = network.makeGetRequest("https://api.example.com/data")
}
```

### Flutter Bridge

```kotlin
import com.yourcompany.flutterlib.FutterBridge

val bridge = FlutterBridge()
val result = bridge.executeFunction("processText", mapOf("input" to " test "))
// result: {"success": true, "result": "TEST"}
```

## Building

```bash
./gradlew build
```

## Testing

```bash
./gradlew test
```

## Publishing

The library is configured to publish to GitHub Packages. Configure your credentials in `gradle.properties` or use environment variables:

- `GITHUB_ACTOR`: Your GitHub username
- `GITHUB_TOKEN`: Your GitHub personal access token

Then run:

```bash
./gradlew publish
```

## License

MIT License - see LICENSE file for details

