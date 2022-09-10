package com.tala.feature_selected_loan.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_data.domain.models.Loan
import com.tala.core_design.theme.Ascent
import com.tala.core_design.theme.Primary

@Composable
 fun MakePaymentCard(loan: Loan, onMakePaymentClicked: () -> Unit) {
    Box(modifier = Modifier.padding(10.dp)) {
        Card(elevation = 4.dp) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "You are on track", modifier = Modifier.padding(10.dp))
                Text(
                    text = "${loan.localeData?.currency} ${loan.formattedAmount}",
                    modifier = Modifier.padding(start = (10.dp), top = 6.dp),
                    fontSize = 30.sp,
                    style = TextStyle(color = Primary)
                )
                Text(
                    text = "is due on ${loan.dueDate}",
                    modifier = Modifier.padding(start = (10.dp), bottom = 10.dp),
                    fontSize = 22.sp,
                    style = TextStyle(color = Color.Gray)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 10.dp, end = 10.dp, bottom = 10.dp
                        ), horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Ascent),
                        onClick = onMakePaymentClicked
                    ) {
                        Text(
                            text = "MAKE PAYMENT", style = TextStyle(color = Color.White)
                        )
                    }
                    TextButton(modifier = Modifier.weight(1f), onClick = { }) {
                        Text(
                            text = "HOW TO REPAY", style = TextStyle(color = Color.DarkGray)
                        )
                    }
                }
            }
        }
    }
}