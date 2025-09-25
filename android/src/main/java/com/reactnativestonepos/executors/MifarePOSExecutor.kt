package com.reactnativestonepos.executors

import android.app.Activity
// import br.com.gertec.gedi.s
// import br.com.stone.posandroid.hal.api.mifare.MifareKeyType
// import br.com.stone.posandroid.providers.PosMifareProvider
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.reactnativestonepos.helpers.ConversionHelpers
import com.reactnativestonepos.helpers.writableArrayFrom
import com.reactnativestonepos.helpers.writableMapOf
import stone.application.enums.Action
import stone.application.interfaces.StoneActionCallback


class MifarePOSExecutor(
  reactApplicationContext: ReactApplicationContext,
  currentActivity: Activity?
) : BaseExecutor(reactApplicationContext, currentActivity) {
  // Temporarily disabled in this Sunmi-only build
  // var mifareProvider: PosMifareProvider? = null

  private fun hexStringToByteArray(hexString: String): ByteArray {
    val hexStringLength = hexString.length
    if (hexStringLength % 2 == 0) {
      return hexString.chunked(2).map {
        it.toInt(16).toByte()
      }.toByteArray()
    } else {
      throw Exception("Hex String needs to be divisible by 2")
    }
  }

  private fun activateCardExecuteBlockAndPowerOff(
    promise: Promise,
    dialogMessage: String? = null,
    dialogTitle: String? = null,
    useDefaultUI: Boolean = false,
    onStatusChangedCallback: ((action: Action?) -> Unit)? = null,
    progressCallbackEventName: String? = null,
    block: (mifareProvider: Any) -> Unit
  ) {
    throw Exception("Mifare is not supported in this build")
  }

  fun executeDetectCard(
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeAuthenticateSector(
    keyType: Int, key: String, sector: Int,
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeReadBlock(
    keyType: Int, key: String,
    sector: Int, block: Int,
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeWriteBlock(
    keyType: Int, key: String,
    sector: Int, block: Int,
    data: String,
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeBackupBlock(
    sector: Byte, srcBlock: Byte, dstBlock: Byte, dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean, promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeRestoreBlock(
    sector: Byte, srcBlock: Byte, dstBlock: Byte, dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean, promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeIncrementValue(
    sector: Byte, block: Byte, value: Byte, dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean, promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }

  fun executeDecrementValue(
    sector: Byte, block: Byte, value: Byte, dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean, promise: Promise
  ) {
    promise.reject("999", "Mifare is not supported in this build")
  }
}
