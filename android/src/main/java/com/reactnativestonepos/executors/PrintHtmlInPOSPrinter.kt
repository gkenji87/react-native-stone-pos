package com.reactnativestonepos.executors

import android.app.Activity
import android.graphics.Bitmap
// import br.com.stone.posandroid.providers.PosPrintProvider
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.izettle.html2bitmap.Html2Bitmap
import com.izettle.html2bitmap.content.WebViewContent
import com.reactnativestonepos.StonePosModule
import com.reactnativestonepos.helpers.CodedException
import com.reactnativestonepos.helpers.StoneTransactionHelpers
import com.reactnativestonepos.helpers.writableMapOf
import stone.application.enums.Action
import stone.application.interfaces.StoneActionCallback
import kotlin.math.ceil

class PrintHtmlInPOSPrinter(
  reactApplicationContext: ReactApplicationContext,
  currentActivity: Activity?
) : BaseExecutor(reactApplicationContext, currentActivity) {
  fun executeAction(
    htmlContent: String,
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    reactApplicationContext.runOnNativeModulesQueueThread {
      checkSDKInitializedAndHandleExceptions(promise) {
        // Temporarily disabled in this Sunmi-only build
        promise.reject("999", "PrintHtmlInPOSPrinter is not supported in this build")
      }
    }
  }
}
