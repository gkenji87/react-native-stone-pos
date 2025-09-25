package com.reactnativestonepos.executors

import android.app.Activity
// import br.com.stone.posandroid.providers.PosPrintReceiptProvider
// import br.com.stone.posandroid.providers.PosReprintReceiptProvider
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.modules.core.DeviceEventManagerModule
import com.reactnativestonepos.StonePosModule
import com.reactnativestonepos.helpers.CodedException
import com.reactnativestonepos.helpers.StoneTransactionHelpers
import com.reactnativestonepos.helpers.writableMapOf
import stone.application.enums.Action
import stone.application.enums.ReceiptType
import stone.application.interfaces.StoneActionCallback
import stone.database.transaction.TransactionDAO

class PrintReceiptInPOSPrinter(
  reactApplicationContext: ReactApplicationContext,
  currentActivity: Activity?
) : BaseExecutor(reactApplicationContext, currentActivity) {
  fun executeAction(
    receiptType: String,
    transactionAtk: String,
    isReprint: Boolean,
    dialogMessage: String?,
    dialogTitle: String?,
    useDefaultUI: Boolean,
    progressCallbackEventName: String,
    promise: Promise
  ) {
    checkSDKInitializedAndHandleExceptions(promise) {
      if (!StoneTransactionHelpers.isRunningInPOS(reactApplicationContext)) {
        throw CodedException("101", "You can only run this in a POS")
      }

      if (StonePosModule.currentUserList.isNullOrEmpty()) {
        throw CodedException("401", "You need to activate the terminal first")
      }

      val transactionDAO = TransactionDAO(reactApplicationContext)
      val transactionObject = transactionDAO.findTransactionWithAtk(transactionAtk)

      if (transactionObject != null) {
        // Temporarily disabled in this Sunmi-only build
        throw CodedException("999", "PrintReceiptInPOSPrinter is not supported in this build")
      } else {
        throw CodedException("402", "Transaction not found")
      }
    }
  }
}
