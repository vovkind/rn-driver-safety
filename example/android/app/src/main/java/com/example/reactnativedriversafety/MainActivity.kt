package com.example.reactnativedriversafety

import com.facebook.react.ReactActivity

class MainActivity : ReactActivity() {
    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @get:Override
    protected val mainComponentName: String
        protected get() = "DriverSafetyExample"
}