package com.tala.feature_selected_loan.presentation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tala.core_data.domain.models.Loan
import com.tala.core_data.domain.models.LoanStatus
import com.tala.core_design.navigation.UiEvent
import com.tala.core_design.theme.Ascent
import com.tala.core_design.theme.Primary
import com.tala.core_design.theme.TalaTheme
import com.tala.core_resources.R
import com.tala.feature_selected_loan.presentation.components.*
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SelectedLoanPage(context: Context, loan: Loan, onNavigate: (UiEvent) -> Unit) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    TalaTheme {
        Scaffold(scaffoldState = scaffoldState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.DarkGray),
            topBar = {
                TopAppBar(
                    backgroundColor = Primary
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        IconButton(onClick = {
                            onNavigate.invoke(UiEvent.NavigateUp)
                        }) {
                            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "back")
                        }
                        Text(
                            text = context.getString(R.string.tala),
                            style = TextStyle(fontSize = 20.sp, color = Color.White)
                        )
                    }
                }
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {

                    if (loan.loanStatus == LoanStatus.APPLY) ApplyLoanCard(loan) {
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(R.string.loanApplied),
                                context.getString(R.string.okay)
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                onNavigate.invoke(UiEvent.NavigateUp)
                            }
                        }

                    }

                    if (loan.loanStatus == LoanStatus.DUE) MakePaymentCard(loan) {
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(R.string.paymentMade),
                                context.getString(R.string.okay)
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                onNavigate.invoke(UiEvent.NavigateUp)
                            }
                        }
                    }

                    if (loan.loanStatus == LoanStatus.PAID) LoanFullyPaid() {
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(R.string.loanApplicationProcess),
                                context.getString(R.string.okay)
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                onNavigate.invoke(UiEvent.NavigateUp)
                            }
                        }
                    }

                    if (loan.loanStatus == LoanStatus.APPROVED) ApplicationApproved(loan) {
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(
                                    R.string.awarded,
                                    loan.localeData?.currency,
                                    loan.formattedAmount
                                ), context.getString(R.string.okay)
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                onNavigate.invoke(UiEvent.NavigateUp)
                            }
                        }
                    }

                    TalaStatus(context, loan) {
                        scope.launch {
                            val result = scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(
                                    R.string.loanLimit,
                                    loan.localeData?.currency,
                                    loan.formattedAmount
                                ), context.getString(R.string.okay)
                            )
                            if (result == SnackbarResult.ActionPerformed) {
                                onNavigate.invoke(UiEvent.NavigateUp)
                            }
                        }
                    }

                    TalaHelpedMeCard(loan) {
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(
                                context.getString(R.string.redirectToWebPage), context.getString(
                                    R.string.okay
                                )
                            )
                        }
                    }

                    InviteFriends()

                    ViewFaqs()
                }
            })
    }
}


@Composable
private fun ViewFaqs() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Card(elevation = 6.dp) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_help),
                    contentDescription = "help",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "View FAQS or send us a message"
                )
            }
        }
    }
}

@Composable
private fun InviteFriends() {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Card(elevation = 6.dp) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "help",
                    colorFilter = ColorFilter.tint(color = Primary),
                    modifier = Modifier
                        .height(30.dp)
                        .width(30.dp)
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp), text = "Invite friends, earn money!"
                )
            }
        }
    }
}


@Composable
@Preview
fun PreviewSelectedLoanPage() {
    //SelectedLoanPage()
}