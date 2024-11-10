plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.notesapp.wear"  // Cambiado para ser único
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notesapp.wear"  // Cambiado aquí
        minSdk = 28  // Asegúrate de que este mínimo sea adecuado para Wear OS
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true  // Si estás usando Jetpack Compose
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"  // Asegúrate de tener la versión correcta
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"  // Para evitar conflictos con licencias
        }
    }
}

dependencies {
    // Dependencias esenciales para Wear OS
    implementation(libs.play.services.wearable)  // Servicios Wear OS

    // Dependencias para Jetpack Compose
    implementation(platform(libs.androidx.compose.bom))  // Utiliza el BOM para controlar las versiones
    implementation(libs.androidx.ui)  // Jetpack Compose UI
    implementation(libs.androidx.ui.tooling.preview)  // Herramientas para la vista previa de Compose
    implementation(libs.androidx.compose.material)  // Material Design para Compose
    implementation(libs.androidx.compose.foundation)  // Composición y disposición
    implementation(libs.androidx.wear.tooling.preview)  // Herramientas específicas para Wear OS
    implementation(libs.androidx.activity.compose)  // Actividad para Compose
    implementation(libs.androidx.core.splashscreen)  // Pantalla de inicio en Wear OS

    // Elimina la dependencia de AppCompat para Wear OS
    // implementation 'androidx.appcompat:appcompat:1.6.0'

    // Dependencias de pruebas
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
