package com.example.currencyconverter.data.models

data class CurrencyResponse(
    val base: String,
    val date: String,
    val disclaimer: String,
    val rates: Rates,
    val timestamp: Int
)