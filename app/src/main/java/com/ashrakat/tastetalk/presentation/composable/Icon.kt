package com.ashrakat.tastetalk.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ashrakat.tastetalk.ui.theme.MainColor
import com.ashrakat.tastetalk.ui.theme.gray_100

@Composable
fun IconsHome(image: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier.size(50.dp),
        shape = CircleShape,
        colors = CardDefaults.cardColors(
            gray_100
        )
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = null,
            modifier = Modifier
                .padding(12.dp)
                .clickable { onClick() }
        )
    }
}

@Composable
fun IconsGeminiResponse(image: Int, onClick: () -> Unit) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "",
        modifier = Modifier.padding(bottom = 4.dp, start = 16.dp,end=8.dp).clickable { onClick() })
}

///////////////////////////
@Composable
fun BackIcon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Icon(
        imageVector = Icons.Default.ArrowBack,
        contentDescription = "Back",
        modifier = modifier.clickable {
            onClick()
        }.padding(start = 8.dp), tint = MainColor
    )
}
