package com.ashrakat.tastetalk.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.ashrakat.tastetalk.R
import com.ashrakat.tastetalk.ui.theme.Background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardSendMessage(
    onSendMessage: (String) -> Unit,
) {

    var userInput by remember { mutableStateOf(TextFieldValue("")) }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(50.dp),
            colors = CardDefaults.cardColors(
                Color.White
            )
        ) {
            Row(
                modifier = Modifier
                    .background(Background),
            ) {

                SendMessageEditText(
                    modifier = Modifier.weight(1f), value = userInput,
                    onChangeValue = {
                        userInput = it
                    }
                )

                Image(
                    painter = painterResource(id = if (userInput.text.isNotBlank()) R.drawable.ic_send_message_focus else R.drawable.ic_send_message_unfocus),
                    contentDescription = null, modifier = Modifier
                        .padding(end = 8.dp)
                        .align(Alignment.CenterVertically)
                        .clickable {
                            if (userInput.text.isNotBlank()) {
                                onSendMessage(userInput.text)
                                userInput = TextFieldValue("")
                            }

                        })
            }
        }
    }


}
