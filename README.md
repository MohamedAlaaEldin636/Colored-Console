# Colored Console
[![](https://jitpack.io/v/MohamedAlaaEldin636/Colored-Console.svg)](https://jitpack.io/#MohamedAlaaEldin636/Colored-Console)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

# Contents [▴](#mautils-gson)

- [Install](#install-)
    - [Jitpack Environment](#jitpack-environment-)
    - [Library](#library-)

- [Features](#features-)

- [Usage Examples](#usage-examples-)

- [License](#license-)

## Install [▴](#contents-)

- [Jitpack Environment](#jitpack-environment-)
- [Library](#library-)

### Jitpack Environment [▴](#install-)

- in your Gradle **Top-level** build file add below code

``` kotlin
// Note this is Kotlin DSL Not Groovy DSL.
allprojects {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Library [▴](#install-)

- X.Y.Z denotes app version which is [![](https://jitpack.io/v/MohamedAlaaEldin636/Colored-Console.svg)](https://jitpack.io/#MohamedAlaaEldin636/Colored-Console)

- in your Gradle **Module-level** build file add below code

``` kotlin
// ...
dependencies {
    implementation("com.github.MohamedAlaaEldin636:Colored-Console:X.Y.Z")
}
```

## Features [▴](#contents-)

- Colors the output of the console if you want.
- Displays the stacktrace as if it was Logcat.

## Usage Examples [▴](#contents-)

``` kotlin
consoleVerboseLn("verbose line")
consolePrintLn("Another line msg", ConsoleLog.reset + ConsoleLog.bold + ConsoleLog.red)
consolePrintLn("Back to normal colors", ConsoleLog.reset)
```

<details>
<summary><i><strong>Java Consumer Code</strong></i></summary>
<p>

``` java
Console.verboseLn("verbose line");
Console.printLn("Another line msg", ConsoleLog.reset + ConsoleLog.bold + ConsoleLog.red);
Console.printLn("Back to normal colors", ConsoleLog.reset);
```

</p>
</details>

- **Produces Below Colors**

![Console Output](https://github.com/MohamedAlaaEldin636/Colored-Console/blob/master/console_output.png)

## [License](https://github.com/MohamedAlaaEldin636/Colored-Console/blob/master/LICENSE) [▴](#contents-)

```
Copyright © 2020 Mohamed Alaa

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing,
software distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.
```

| Permissions         | Limitations           | Conditions   |
| ------------------- | --------------------- | ----------- |
| :heavy_check_mark: Commercial Use | :x: Trademark use | :information_source: License and copyright notice |
| :heavy_check_mark: Modification | :x: Liability | :information_source: State changes |
| :heavy_check_mark: Distribution | :x: Warranty | - |
| :heavy_check_mark: Patent use | - | - |
| :heavy_check_mark: Private use | - | - |
