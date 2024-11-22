package com.ashrakat.tastetalk.presentation.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ashrakat.tastetalk.R
import com.ashrakat.tastetalk.ui.theme.MainColor
import com.ashrakat.tastetalk.ui.theme.TextColor

@Composable
fun WelcomeText(modifier: Modifier = Modifier){
    Text(
        text=stringResource(R.string.welcome),
        modifier = modifier
            .padding(top = 16.dp),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = TextColor
    )
}

@Composable
fun StartExploringText(text:String,modifier: Modifier = Modifier){
    Text(
        text
        ,
        modifier = modifier,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        color = Color.LightGray
    )
}
/////////////////////////
@Composable
fun TitleText(text:String,modifier: Modifier = Modifier){
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            modifier = modifier,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = MainColor,
        )
    }

}




