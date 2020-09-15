package com.example.reactnativedriversafety

import android.app.Application
import android.content.Context
import com.facebook.react.PackageList
import com.facebook.react.ReactApplication
import com.facebook.react.ReactNativeHost
import com.facebook.react.ReactPackage
import com.facebook.react.ReactInstanceManager
import com.facebook.soloader.SoLoader
import java.lang.reflect.InvocationTargetException
import java.util.List
import com.reactnativedriversafety.DriverSafetyPackage

class MainApplication : Application(), ReactApplication {
    private val mReactNativeHost: ReactNativeHost = object : ReactNativeHost(this) {
        @get:Override
        val useDeveloperSupport: Boolean
            get() = BuildConfig.DEBUG

        // Packages that cannot be autolinked yet can be added manually here, for DriverSafetyExample:
        // packages.add(new MyReactNativePackage());
        @get:Override
        protected val packages: List<Any>
            protected get() {
                @SuppressWarnings("UnnecessaryLocalVariable") val packages: List<ReactPackage> = PackageList(this).getPackages()
                // Packages that cannot be autolinked yet can be added manually here, for DriverSafetyExample:
                // packages.add(new MyReactNativePackage());
                packages.add(DriverSafetyPackage())
                return packages
            }

        @get:Override
        protected val jSMainModuleName: String
            protected get() = "index"
    }

    @get:Override
    val reactNativeHost: ReactNativeHost
        get() = mReactNativeHost

    @Override
    fun onCreate() {
        super.onCreate()
        SoLoader.init(this,  /* native exopackage */false)
    }
}