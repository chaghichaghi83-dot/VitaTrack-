package com.vitatrack.app.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HistoryChartsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Activity History",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Weekly Steps")
                Text("Mon  2,500")
                Text("Tue  4,200")
                Text("Wed  3,800")
                Text("Thu  5,100")
                Text("Fri  6,000")
                Text("Sat  4,700")
                Text("Sun  3,200")
            }
        }

        Text(
            text = "These are sample values, not saved activity records.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
