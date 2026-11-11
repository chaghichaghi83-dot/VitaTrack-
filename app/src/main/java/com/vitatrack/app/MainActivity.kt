package com.vitatrack.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.vitatrack.app.sensors.StepSensorTracker
import com.vitatrack.app.ui.screens.*

class MainActivity : ComponentActivity() {

    private lateinit var stepTracker: StepSensorTracker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        stepTracker = StepSensorTracker(this)

        setContent {
            val steps by stepTracker.steps.collectAsState(initial = 0)
            var selectedTab by remember { mutableIntStateOf(0) }

            MaterialTheme {
                Scaffold(
                    bottomBar = {
                        NavigationBar {
                            NavigationBarItem(
                                selected = selectedTab == 0,
                                onClick = { selectedTab = 0 },
                                icon = {},
                                label = { Text("Home") }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 1,
                                onClick = { selectedTab = 1 },
                                icon = {},
                                label = { Text("History") }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 2,
                                onClick = { selectedTab = 2 },
                                icon = {},
                                label = { Text("Devices") }
                            )
                            NavigationBarItem(
                                selected = selectedTab == 3,
                                onClick = { selectedTab = 3 },
                                icon = {},
                                label = { Text("Profile") }
                            )
                        }
                    }
                ) { padding ->
                    Surface(modifier = Modifier.padding(padding)) {
                        when (selectedTab) {
                            0 -> DashboardScreen(steps = steps)
                            1 -> HistoryChartsScreen()
                            2 -> DevicesScreen()
                            3 -> ProfileScreen()
                        }
                    }
                }
            }
        }

        checkStepPermission()
    }

    private fun checkStepPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q &&
            ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACTIVITY_RECOGNITION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                100
            )
        } else {
            stepTracker.start()
        }
    }

    override fun onResume() {
        super.onResume()
        if (::stepTracker.isInitialized) {
            checkStepPermission()
        }
    }

    override fun onPause() {
        super.onPause()
        if (::stepTracker.isInitialized) {
            stepTracker.stop()
        }
    }
}
