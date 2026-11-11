package com.vitatrack.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vitatrack.app.ads.AdMobBannerView
import com.vitatrack.app.ui.components.MedicalDisclaimerCard

@Composable
fun DashboardScreen(steps: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "VitaTrack",
            fontSize = 28.sp,
            style = MaterialTheme.typography.headlineMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Daily Steps", style = MaterialTheme.typography.titleMedium)
                Text(
                    text = steps.toString(),
                    fontSize = 36.sp
                )
            }
        }

        MedicalDisclaimerCard()

        Spacer(modifier = Modifier.weight(1f))

        AdMobBannerView(modifier = Modifier.fillMaxWidth())
    }
}
