plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.azreashade.grimoireofgrowth"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.azreashade.grimoireofgrowth"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "0.1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug { isMinifyEnabled = false }
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // DataStore (fixes unresolved references in SettingsStore)
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Coroutines (often used with DataStore/Room)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Kapt (no direct dep needed; plugin is applied)
    // Room/other deps can be added later as needed.
}
