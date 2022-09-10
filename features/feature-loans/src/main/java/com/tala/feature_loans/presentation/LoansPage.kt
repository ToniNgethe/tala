package com.tala.feature_loans.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.tala.core_data.domain.models.Loan
import com.tala.core_design.navigation.UiEvent
import com.tala.core_design.theme.Primary
import com.tala.core_design.theme.TalaTheme
import com.tala.core_resources.R
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.text.DecimalFormat

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoansPage(viewmodel: LoansVm = hiltViewModel(), onEvent: (UiEvent) -> Unit) {
    val state = viewmodel.loanUiState.collectAsState()

    TalaTheme {
        Scaffold(modifier = Modifier.background(MaterialTheme.colors.background), topBar = {
            TopAppBar(
                backgroundColor = Primary
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.tala_circle),
                        modifier = Modifier
                            .height(30.dp)
                            .width(30.dp)
                            .padding(end = 6.dp),
                        contentDescription = "logo",
                    )
                    Text(
                        text = "Your loans", style = TextStyle(fontSize = 20.sp, color = Color.White)
                    )
                }
            }
        }, content = {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                if (state.value.errorMessage != null) Text(text = state.value.errorMessage ?: "")
                if (state.value.isLoading) CircularProgressIndicator(strokeWidth = 2.dp)
            }

            if (state.value.loans.isNotEmpty()) LazyColumn(
                contentPadding = PaddingValues(all = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(state.value.loans) { loanItem ->
                    LoanItem(loanItem) {
                        onEvent.invoke(
                            UiEvent.OnNavigate(
                                "selected_loan_page?loan=" + Json.encodeToString(loanItem)
                            )
                        )
                    }
                }
            }


        })
    }
}

@Composable
private fun LoanItem(loanItem: Loan, onLoanItemClicked: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onLoanItemClicked.invoke() },
        elevation = 6.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = loanItem.icon),
                modifier = Modifier
                    .height(65.dp)
                    .width(65.dp)
                    .padding(10.dp),
                contentDescription = "status"
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp)
            ) {
                Text(
                    text = loanItem.name ?: "", style = TextStyle(
                        color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp
                    )
                )
                if (loanItem.amount != null) Text(
                    modifier = Modifier.padding(top = 6.dp),
                    text = "${loanItem.localeData?.currency} ${
                        loanItem.formattedAmount
                    }"
                )
            }
            Text(
                text = loanItem.loanStatus.toString().lowercase().capitalize(),
                style = TextStyle(fontSize = 13.sp, color = Color.Gray)
            )
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight, contentDescription = ""
            )
        }
    }
}


@Preview
@Composable
fun PreviewLoansPage() {
    //LoansPage()
}