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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_data.domain.models.Loan
import com.tala.core_design.theme.Ascent
import com.tala.core_resources.R

@Composable
 fun ApplyLoanCard(loan: Loan, onApplyClicked: () -> Unit) {
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
                        painter = painterResource(id = R.drawable.img_loan_status_apply),
                        contentDescription = "apply"
                    )

                }

                Text(
                    text = stringResource(id = R.string.applyLoan),
                    modifier = Modifier.padding(6.dp),
                    style = TextStyle(
                        fontSize = 20.sp
                    )
                )

                Text(
                    text = "Repay on time to get loans up to ${loan.localeData?.currency} ${loan.localeData?.loanLimit}",
                    modifier = Modifier.padding(5.dp)
                )

                Button(
                    modifier = Modifier.padding(10.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Ascent),
                    onClick = onApplyClicked
                ) {
                    Text(
                        text = "APPLY NOW", style = TextStyle(color = Color.White)
                    )
                }
            }

        }
    }
}