package com.ashrakat.tastetalk.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@Composable
fun SendMessageEditText(
    modifier: Modifier = Modifier,
    value: TextFieldValue,
    onChangeValue: (TextFieldValue) -> Unit,

) {
    BasicTextField(
        value = value,
        onValueChange = onChangeValue,
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                if (value.text.isEmpty()) {
                    Text(
                        text = "Type a message",
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        }
    )
}


