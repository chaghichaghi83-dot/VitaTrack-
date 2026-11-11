package com.vitatrack.app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MedicalDisclaimerCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        colors = CardDefaults.cardColors()
    ) {
        Text(
            text = "VitaTrack is a wellness tracking app, not a medical device. It does not provide medical diagnosis.",
            modifier = Modifier.padding(16.dp),
            fontSize = 14.sp
        )
    }
}
