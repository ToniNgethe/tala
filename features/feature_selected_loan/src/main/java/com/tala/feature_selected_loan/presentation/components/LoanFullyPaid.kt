package com.tala.feature_selected_loan.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_design.theme.Ascent
import com.tala.core_resources.R

@Composable
fun LoanFullyPaid(onLoanAppliedClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Card(elevation = 4.dp) {
            Column {
                Box(contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(id = R.drawable.waves_bg_light_pattern),
                        contentDescription = "waves",
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    Image(
                        painter = painterResource(id = R.drawable.img_loan_status_paidoff),
                        contentDescription = "apply"
                    )

                }

                Text(
                    text = stringResource(id = R.string.loanFullyPaid),
                    modifier = Modifier.padding(6.dp),
                    style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.W700
                    )
                )

                Text(
                    text = stringResource(id = R.string.applyForLoan),
                    modifier = Modifier.padding(5.dp)
                )

                Button(
                    modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Ascent),
                    onClick = onLoanAppliedClicked
                ) {
                    Text(
                        text = stringResource(id = R.string.applyNow),
                        style = TextStyle(color = Color.White)
                    )
                }
            }

        }
    }
}