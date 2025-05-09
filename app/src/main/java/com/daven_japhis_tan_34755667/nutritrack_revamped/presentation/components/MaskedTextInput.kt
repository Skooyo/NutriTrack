package com.daven_japhis_tan_34755667.nutritrack_revamped.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MaskedInputField(
    textInput: String,
    onTextChange: (String) -> Unit,
    visibility: Boolean,
    toggleVisibility: () -> Unit,
    label: String,
    modifier: Modifier,
) {
    OutlinedTextField(
        value = textInput,
        onValueChange = onTextChange,
        modifier = Modifier.fillMaxWidth(),
        label = { Text(
            text = label,
            color = if(textInput.isEmpty()) Color.LightGray else Color.Black,
        ) },
        singleLine = true,
        visualTransformation = if (!visibility) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Box(
                modifier = Modifier.clickable(onClick = toggleVisibility)
            ) {
                Icon(
                    imageVector = Icons.Default.Search, // Replace with VisibilityOff for closed eye
                    contentDescription = "Toggle Text Visibility"
                )
            }
        }
    )
}