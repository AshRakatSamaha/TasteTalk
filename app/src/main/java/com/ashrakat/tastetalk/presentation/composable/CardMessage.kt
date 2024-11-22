package com.ashrakat.tastetalk.presentation.composable


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ashrakat.tastetalk.R
import com.ashrakat.tastetalk.ui.theme.MainColor
import com.ashrakat.tastetalk.ui.theme.SecondaryColor
import com.ashrakat.tastetalk.ui.theme.TextColor


@Composable
fun ChatMessage(
    message: String,
    isUser: Boolean,
    onClickToCopyMessage: () -> Unit,
    onClickToStarMessage: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        contentAlignment = if (isUser) Alignment.CenterEnd else Alignment.CenterStart
    ) {
        Card(
            colors = CardDefaults.cardColors(
                if (isUser) MainColor else SecondaryColor
            ),
            modifier = Modifier
                .padding(
                    start = if (isUser) 40.dp else 8.dp,
                    end = if (isUser) 8.dp else 40.dp
                ),
        ) {
            Text(
                text = message,
                color = if (isUser) Color.White else TextColor,
                modifier = Modifier.padding(8.dp)
            )
            if (!isUser) {
                Row {
                    IconsGeminiResponse(
                        image = R.drawable.ic_copy,
                        onClick = { onClickToCopyMessage() })

                    IconsGeminiResponse(
                        image = R.drawable.ic_star,
                        onClick = { onClickToStarMessage() })
                }
            }
        }
    }
}

