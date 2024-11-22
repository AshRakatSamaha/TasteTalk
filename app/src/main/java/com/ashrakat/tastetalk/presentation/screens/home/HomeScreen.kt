package com.ashrakat.tastetalk.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ashrakat.tastetalk.R
import com.ashrakat.tastetalk.presentation.composable.IconsHome
import com.ashrakat.tastetalk.presentation.composable.StartExploringText
import com.ashrakat.tastetalk.presentation.composable.WelcomeText
import com.ashrakat.tastetalk.ui.theme.Background

@Composable
fun HomeScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {

            Image(
                painter = painterResource(id = R.drawable.ic_chat_bot),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp)
            )

            WelcomeText(modifier = Modifier.align(Alignment.CenterHorizontally))
            StartExploringText(
                text = stringResource(id = R.string.startExploring),
                modifier = Modifier
                    .padding(top = 24.dp)
                    .align(Alignment.CenterHorizontally)
            )
            StartExploringText(
                text = stringResource(id = R.string.all),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 90.dp, vertical = 120.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconsHome(image = R.drawable.ic_chat, onClick = {
                    navController.navigate("geminiChatScreen")
                })
                IconsHome(image = R.drawable.ic_star, onClick = {
                    navController.navigate("starMessageScreen")
                })
            }
        }

    }
}

