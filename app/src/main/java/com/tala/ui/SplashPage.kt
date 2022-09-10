package com.tala.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_design.navigation.Routes
import com.tala.core_design.navigation.UiEvent
import com.tala.core_design.theme.TalaTheme
import com.tala.core_resources.R
import kotlinx.coroutines.delay

@Composable
fun SplashPage(modifier: Modifier = Modifier, onNavigate: (UiEvent) -> Unit) {

    LaunchedEffect(Unit) {
        delay(2000)
        onNavigate.invoke(UiEvent.OnNavigate(Routes.loansPage))
    }

    TalaTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.tala_circle),
                    contentDescription = "logo"
                )
                Text(
                    modifier = Modifier.padding(16.dp), text = "Welcome to Tala", style = TextStyle(
                        color = MaterialTheme.colors.onSurface, fontSize = 18.sp
                    )
                )
            }
        }
    }
}


@Preview
@Composable
fun PreviewSplashPage() {
    SplashPage() {

    }
}