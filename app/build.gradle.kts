/*
 * Copyright (C) 2019 Hideki Shiro
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jetbrains.kotlin.config.KotlinCompilerVersion;

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "org.theta4j.webui"
        minSdkVersion(28)
        targetSdkVersion(28)
        versionCode = 2
        versionName = "1.0.1"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFile(getDefaultProguardFile("proguard-android-optimize.txt"))
            proguardFile("proguard-rules.pro")
        }
    }
    signingConfigs {
        create("release") {
            storeFile = rootProject.file("theta-plugin-web-ui-browser.keystore")
            storePassword = properties["android.keystore.password"] as String
            keyAlias = properties["android.keystore.alias"] as String
            keyPassword = properties["android.keystore.private_key_password"] as String
        }
    }
    buildTypes["release"].signingConfig = signingConfigs["release"]
}

dependencies {
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))
    implementation("com.android.support", "appcompat-v7", "28.0.0")
    implementation("com.android.support.constraint", "constraint-layout", "1.1.3")
    testImplementation("junit", "junit", "4.12")
    androidTestImplementation("com.android.support.test", "runner", "1.0.2")
    androidTestImplementation("com.android.support.test.espresso", "espresso-core", "3.0.2")
}
