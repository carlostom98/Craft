package org.carams.project

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager

actual class BatteryManager(
    private val context: Context
) {
    actual fun getBatteryLevel(): Int {
        val intentFilter = IntentFilter(Intent.ACTION_BATTERY_CHANGED)
        val batteryStatus = context.registerReceiver(null, intentFilter)
        return batteryStatus?.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) ?: -1
    }
}