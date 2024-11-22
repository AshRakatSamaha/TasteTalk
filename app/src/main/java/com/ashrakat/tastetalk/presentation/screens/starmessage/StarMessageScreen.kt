package com.ashrakat.tastetalk.presentation.screens.starmessage

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.ashrakat.tastetalk.R
import com.ashrakat.tastetalk.presentation.composable.BackIcon
import com.ashrakat.tastetalk.presentation.composable.TitleText
import com.ashrakat.tastetalk.presentation.mvvm.StarMessageViewModel
import com.ashrakat.tastetalk.ui.theme.gray_100

@Composable
fun StarMessageScreen(
    viewModel: StarMessageViewModel = hiltViewModel(),
    navController: NavController
) {
    val starMessage by viewModel.starredMessages.collectAsState()

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 32.dp)
        ) {
            BackIcon(
                onClick = {
                    navController.popBackStack()
                })
            TitleText(
                text = stringResource(id = R.string.starredMessage),
            )


        }

        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(starMessage) { message ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = CardDefaults.cardColors(
                        gray_100
                    ),
                    shape = RoundedCornerShape(16.dp),
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = message.content, modifier = Modifier.weight(1f))

                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete",
                            tint = Color.Red, modifier = Modifier.clickable {
                                viewModel.deleteStarredMessage(message)
                                Toast.makeText(
                                    navController.context,
                                    "Message deleted",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                }
            }

        }
    }
}
