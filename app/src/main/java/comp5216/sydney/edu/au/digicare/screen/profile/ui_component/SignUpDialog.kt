package comp5216.sydney.edu.au.digicare.screen.profile.ui_component

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun SignUpDialog(
    onDismissRequest: () -> Unit,
    onConfirmClick: (String, String) -> Unit
) {
    // State for storing email and password inputs
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    // Dialog for email and password input
    AlertDialog(
        onDismissRequest = onDismissRequest,
        title = {
            Text(text = "Enter Email and Password")
        },
        text = {
            Column {
                TextField(
                    value = email,
                    onValueChange = { email = it },
                    label = { Text(text = "Email") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "Password") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = PasswordVisualTransformation() // For password input
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onConfirmClick(email, password)
                    onDismissRequest() // Dismiss the dialog after confirming
                }
            ) {
                Text(text = "Sign Up")
            }
        },
        dismissButton = {
            Button(onClick = onDismissRequest) {
                Text(text = "Cancel")
            }
        }
    )
}


