package comp5216.sydney.edu.au.digicare.screen.summary.ui_component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import comp5216.sydney.edu.au.digicare.screen.summary.SummaryViewModel

@Composable
fun GenerateDialog(viewModel: SummaryViewModel, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    // State to control the visibility of the dialog
    val scrollState = rememberScrollState()
    val analysisResult by viewModel.analysisResult.collectAsState()

    AlertDialog(
        onDismissRequest = {
            onDismiss()
        },
        title = {
            Text(
                text = "Preview Summary",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Medium
            )
        },
        text = {
            // LazyColumn for better performance with long lists
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                    .padding(16.dp)
                    .verticalScroll(scrollState)
            ) {
                Text(
                    text = analysisResult // Display the generated summary
                )
            }
        },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Save")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    )
}
