# Zygote Module Creation
This script was design to work with this [template](https://github.com/matiasdelbel/android-zygote-multi-modules).

## Input & Output
You only need to enter the **feature name** and the **base package**. Please notice that the script will append to **base package**
the feature name and also the layer name.

For example, if your feature name is "name" and you entered "com.package" as base package, the package name for the domain layer
will be ``com.package.name.domain``.

As a result of running this script, the following files will be created:
```
DIRECTORY: > /domain
 NEW file: > /domain/proguard-rules.pro (source: /hard/proguard-rules.pro)
 NEW file: > /domain/.gitignore (source: /hard/.gitignore)
 NEW file: > /domain/build.gradle.kts (dynamic content)
DIRECTORY: > /domain/src/main/kotlin/com/delbel/zygote/domain
 NEW file: > /domain/src/main/AndroidManifest.xml (dynamic content)
DIRECTORY: > /domain/src/test/kotlin/com/delbel/zygote/domain
 NEW file: > /domain/src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker (source: /hard/org.mockito.plugins.MockMaker)
APPENDED: > /settings.gradle.kts
DIRECTORY: > /presentation
 NEW file: > /presentation/proguard-rules.pro (source: /hard/proguard-rules.pro)
 NEW file: > /presentation/.gitignore (source: /hard/.gitignore)
 NEW file: > /presentation/build.gradle.kts (dynamic content)
DIRECTORY: > /presentation/src/main/kotlin/com/delbel/zygote/presentation
 NEW file: > /presentation/src/main/AndroidManifest.xml (dynamic content)
DIRECTORY: > /presentation/src/test/kotlin/com/delbel/zygote/presentation
 NEW file: > /presentation/src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker (source: /hard/org.mockito.plugins.MockMaker)
APPENDED: > /settings.gradle.kts
DIRECTORY: > /gateway
 NEW file: > /gateway/proguard-rules.pro (source: /hard/proguard-rules.pro)
 NEW file: > /gateway/.gitignore (source: /hard/.gitignore)
 NEW file: > /gateway/build.gradle.kts (dynamic content)
DIRECTORY: > /gateway/src/main/kotlin/com/delbel/zygote/gateway
 NEW file: > /gateway/src/main/AndroidManifest.xml (dynamic content)
DIRECTORY: > /gateway/src/test/kotlin/com/delbel/zygote/gateway
 NEW file: > /gateway/src/test/resources/mockito-extensions/org.mockito.plugins.MockMaker (source: /hard/org.mockito.plugins.MockMaker)
APPENDED: > /settings.gradle.kts
```