package com.vitatrack.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "My Profile",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("VitaTrack User")
                Text("Personal activity dashboard")
            }
        }

        Text(
            text = "Privacy and Settings",
            style = MaterialTheme.typography.titleMedium
        )

        Text("Your activity data stays on this device.")
        Text("Data deletion settings are not available yet.")
    }
}
