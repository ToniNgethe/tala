package com.tala.feature_selected_loan.presentation.components

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_data.domain.models.Loan
import com.tala.core_data.domain.models.LoanStatus
import com.tala.core_design.theme.Ascent
import com.tala.core_resources.R

@SuppressLint("ProduceStateDoesNotAssignValue")
@Composable
fun TalaStatus(context: Context, loan: Loan, onViewTrackClicked: () -> Unit) {
    val statusStatement by produceState(initialValue = "") {
        value = when (loan.loanStatus) {
            LoanStatus.APPLY -> {
                context.getString(R.string.trackProgress)
            }
            LoanStatus.PAID, LoanStatus.DUE, LoanStatus.APPROVED -> {
                context.getString(
                    R.string.growLimit, loan.localeData?.currency, loan.localeData?.loanLimit
                )
            }
            else -> {
                ""
            }
        }
    }
    Box(modifier = Modifier.padding(10.dp)) {
        Card(elevation = 6.dp) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                ) {
                    Text(
                        text = stringResource(com.tala.feature_selected_loan.R.string.tala_status),
                        style = TextStyle(fontSize = 28.sp, color = Color.Black)
                    )
                    Text(
                        text = statusStatement, style = TextStyle(Color.DarkGray, fontSize = 16.sp)
                    )

                    TextButton(onClick = onViewTrackClicked) {
                        Text(
                            text = stringResource(com.tala.feature_selected_loan.R.string.view_status),
                            style = TextStyle(color = Ascent)
                        )
                    }
                }
                Image(
                    painter = painterResource(id = loan.icon),
                    modifier = Modifier
                        .height(90.dp)
                        .width(90.dp),
                    contentDescription = "status"
                )
            }
        }
    }
}