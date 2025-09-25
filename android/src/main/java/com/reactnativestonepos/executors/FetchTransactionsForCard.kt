package com.reactnativestonepos.executors

import android.app.Activity
// import br.com.stone.posandroid.providers.PosValidateTransactionByCardProvider
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.reactnativestonepos.StonePosModule
import com.reactnativestonepos.helpers.*
import stone.application.enums.Action
import stone.application.interfaces.StoneActionCallback
import stone.providers.ValidateTransactionByCardProvider
import stone.utils.PinpadObject
import stone.utils.Stone

class FetchTransactionsForCard(
  reactApplicationContext: ReactApplicationContext,
  currentActivity: Activity?
) : BaseExecutor(reactApplicationContext, currentActivity) {
  fun executeAction(
    pinpadMacAddress: String?,
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    try {
      if (StoneTransactionHelpers.isSDKInitialized()) {
        if (StonePosModule.currentUserList.isNullOrEmpty()) {
          throw CodedException("401", "You need to activate the terminal first")
        }

        if (StoneTransactionHelpers.isRunningInPOS(reactApplicationContext)) {
          throw CodedException(
            "402",
            "You are running in POS mode, there's no support for PinPad messages"
          )
        }

        val selectedPinPad: PinpadObject? =
          if (StoneTransactionHelpers.isRunningInPOS(reactApplicationContext)) {
            null
          } else {
            if (!pinpadMacAddress.isNullOrEmpty()) {
              Stone.getPinpadObjectList().findLast {
                it.macAddress == pinpadMacAddress
              } ?: throw CodedException("401", "Pinpad not found")
            } else {
              if (Stone.getPinpadListSize() > 0) {
                Stone.getPinpadFromListAt(0)
              } else {
                throw CodedException("401", "No pinpad connected")
              }
            }
          }

        // Temporarily disabled in this Sunmi-only build
        throw CodedException("999", "FetchTransactionsForCard is not supported in this build")
      }
    } catch (e: CodedException) {
      promise.reject(e.code, e.internalMessage)
    } catch (e: Exception) {
      promise.reject(e)
    }
  }
}
