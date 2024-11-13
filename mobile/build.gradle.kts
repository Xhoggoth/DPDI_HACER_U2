plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.notesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.notesapp"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        // Configuración del runner para las pruebas instrumentadas
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    // Configuración para las pruebas unitarias
    testOptions {
        unitTests.isIncludeAndroidResources = true  // Incluye recursos Android en pruebas unitarias
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.play.services.wearable)  // Dependencia para servicios Wear OS
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Dependencias de pruebas
    testImplementation(libs.junit)  // Para pruebas unitarias con JUnit
    androidTestImplementation(libs.androidx.junit)  // Para pruebas instrumentadas
    androidTestImplementation(libs.androidx.espresso.core)  // Para pruebas de interfaz

    // Si estás utilizando un módulo Wear OS, asegúrate de incluirlo correctamente
    wearApp(project(":wear"))  // Asegúrate de tener esta línea si el módulo Wear está en el proyecto
}

// Configuración para ejecutar pruebas unitarias
tasks.withType<Test> {
    useJUnitPlatform()  // Usar JUnit para pruebas unitarias
}
