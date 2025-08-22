package org.carams.project

import platform.UIKit.UIDevice

actual class BatteryManager {
    actual fun getBatteryLevel(): Int {
        UIDevice.currentDevice.batteryMonitoringEnabled = true
        val batteryLevel = UIDevice.currentDevice.batteryLevel
        return if (batteryLevel < 0) -1 else (batteryLevel * 100).toInt()
    }
}