package com.tala.core_design.navigation

sealed class UiEvent {
    data class OnNavigate(val route: String, val args: String? = null) : UiEvent()
    object NavigateUp : UiEvent()
}