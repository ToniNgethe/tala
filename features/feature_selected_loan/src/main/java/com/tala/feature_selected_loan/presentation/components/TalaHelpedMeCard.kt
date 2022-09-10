package com.tala.feature_selected_loan.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_data.domain.models.Loan
import com.tala.core_resources.R

@Composable
fun TalaHelpedMeCard(loan: Loan, readMoreClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        Card(elevation = 6.dp) {
            Image(
                painter = painterResource(id = loan.storyCard),
                contentDescription = "story",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Column {
                Text(
                    modifier = Modifier.padding(10.dp),
                    text = stringResource(id = R.string.talaHelpedMe),
                    style = TextStyle(
                        color = Color.White, fontWeight = FontWeight.W600, fontSize = 28.sp
                    )
                )
                TextButton(onClick = readMoreClicked) {
                    Text(
                        text = stringResource(id = R.string.readMore),
                        style = TextStyle(color = Color.White)
                    )
                }
            }
        }

    }
}