package com.tala.core_data.domain.models

enum class LoanStatus {
    DUE, APPROVED, PAID, APPLY;
}

fun getLoanStatusFromString(value: String?): LoanStatus {
    return when (value) {
        "due" -> LoanStatus.DUE
        "approved" -> LoanStatus.APPROVED
        "paid" -> LoanStatus.PAID
        else -> {
            LoanStatus.APPLY
        }
    }
}

fun getLoanLevelDrawable(level: String?): Int = when (level) {
    "silver" -> com.tala.core_resources.R.drawable.img_silver_badge_large
    "gold" -> com.tala.core_resources.R.drawable.img_gold_badge_large
    "bronze" -> com.tala.core_resources.R.drawable.img_bronze_badge_large
    else -> {
        com.tala.core_resources.R.drawable.img_blue_badge_large
    }
}

fun getStoryCardImage(country: String?): Int = when (country) {
    "ke" -> com.tala.core_resources.R.drawable.img_story_card_ke
    "mx" -> com.tala.core_resources.R.drawable.img_story_card_mx
    "ph" -> com.tala.core_resources.R.drawable.img_story_card_ph
    else -> {
        com.tala.core_resources.R.drawable.img_story_card_ke
    }
}