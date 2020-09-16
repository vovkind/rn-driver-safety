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

    fun isNeedPermissions(context: Context): Boolean {
      val fineLocation = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
      val coarseLocation = ContextCompat.checkSelfPermission(context, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
      val backgroundLocation = false
      //        if (android.os.Build.VERSION.SDK_INT >= 29) {
      //            backgroundLocation = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_BACKGROUND_LOCATION) != PackageManager.PERMISSION_GRANTED;
      //        }
      val activityRecognition = false
      //        if (android.os.Build.VERSION.SDK_INT >= 29) {
      //            activityRecognition = ContextCompat.checkSelfPermission(context, Manifest.permission.ACTIVITY_RECOGNITION) != PackageManager.PERMISSION_GRANTED;
      //        }
      val rs = ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
      val ws = ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED
      return fineLocation || coarseLocation || backgroundLocation || rs || ws || activityRecognition
    }

    fun requestPermissions(activity: Activity) {
          /*        if (Build.VERSION.SDK_INT >= 29) {
              ActivityCompat.requestPermissions(
                      activity,
                      new String[]{
                              Manifest.permission.ACCESS_FINE_LOCATION,
                              Manifest.permission.ACCESS_COARSE_LOCATION,
                              Manifest.permission.ACCESS_BACKGROUND_LOCATION,
                              Manifest.permission.ACTIVITY_RECOGNITION,
                              Manifest.permission.WRITE_EXTERNAL_STORAGE,
                              Manifest.permission.READ_EXTERNAL_STORAGE,
                      },
                      REQUEST_EXTERNAL_STORAGE
              );
          } else*/ ActivityCompat.requestPermissions(
                  activity,
                  arrayOf(
                          Manifest.permission.ACCESS_FINE_LOCATION,
                          Manifest.permission.ACCESS_COARSE_LOCATION,
                          Manifest.permission.WRITE_EXTERNAL_STORAGE,
                          Manifest.permission.READ_EXTERNAL_STORAGE
                  ),
                  Companion.REQUEST_EXTERNAL_STORAGE
          )
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (isNeedPermissions(this)) {
            //Toast.makeText(this, "Need permissions!", Toast.LENGTH_SHORT).show()
            requestPermissions(this)
        } else {
            enableSDK()
        }
    }

    fun enableSDK() {
      TrackingApi.getInstance().setDeviceID("da630ebf-8765-4014-a43a-a93889749554")
      TrackingApi.getInstance().setEnableSdk(true)
    }

    companion object {
      @JvmStatic
      fun init(context: Context) {
        if (isNeedPermissions(context)) {
            requestPermissions(context)
        }else{
            enableSDK()
        }
      }

      private const val YOUR_TOKEN = ""  // set your token
      private const val REQUEST_EXTERNAL_STORAGE = 1
    }
}
