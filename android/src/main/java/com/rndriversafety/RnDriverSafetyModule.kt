package com.rndriversafety

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.facebook.react.bridge.Promise
import com.raxeltelematics.v2.sdk.TrackingApi


class RnDriverSafetyModule(reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "RnDriverSafety"
    }

    // Example method
    // See https://facebook.github.io/react-native/docs/native-modules-android
    @ReactMethod
    fun multiply(a: Int, b: Int, promise: Promise) {
        promise.resolve(a * b)
    }

    @ReactMethod
    fun enable(deviceId: String) {
        enableSDK(deviceId)
    }

    @ReactMethod
    fun disable() {
        disableSDK()
    }

    fun enableSDK(deviceId: String) {
      TrackingApi.getInstance().setDeviceID(deviceId)
      TrackingApi.getInstance().setEnableSdk(true)
    }

    fun disableSDK() {
      TrackingApi.getInstance().setEnableSdk(false)
    }
}
