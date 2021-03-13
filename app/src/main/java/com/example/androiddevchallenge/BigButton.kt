package com.example.androiddevchallenge

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BigButton(text: String, backgroundColor: Color, onClick: (() -> Unit)? = null) {
    Button(
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = backgroundColor,
            contentColor = MaterialTheme.colors.contentColorFor(backgroundColor)
        ),
        shape = MaterialTheme.shapes.medium,
        onClick = { onClick?.invoke() }, modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Text(text.toUpperCase()) // TODO: capitalization throught style
    }
}