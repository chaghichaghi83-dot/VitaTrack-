package com.vitatrack.app.devices

import java.util.UUID

object BleStandardUuids {
    val HEART_RATE_SERVICE: UUID =
        UUID.fromString("0000180d-0000-1000-8000-00805f9b34fb")

    val HEART_RATE_MEASUREMENT: UUID =
        UUID.fromString("00002a37-0000-1000-8000-00805f9b34fb")

    val PULSE_OXIMETER_SERVICE: UUID =
        UUID.fromString("00001822-0000-1000-8000-00805f9b34fb")

    val PULSE_OXIMETER_MEASUREMENT: UUID =
        UUID.fromString("00002a5f-0000-1000-8000-00805f9b34fb")
}

data class ExternalVitalsState(
    val heartRate: Int? = null,
    val oxygenLevel: Int? = null,
    val isConnected: Boolean = false
)
