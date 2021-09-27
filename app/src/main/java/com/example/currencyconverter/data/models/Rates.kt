package com.example.currencyconverter.data.models

import com.google.gson.annotations.SerializedName

data class Rates(
    @SerializedName("AMD")
    val AMD: Double,
    @SerializedName("AUD")
    val AUD: Double,
    @SerializedName("AZN")
    val AZN: Double,
    @SerializedName("BGN")
    val BGN: Double,
    @SerializedName("BRL")
    val BRL: Double,
    @SerializedName("BYN")
    val BYN: Double,
    @SerializedName("CAD")
    val CAD: Double,
    @SerializedName("CHF")
    val CHF: Double,
    @SerializedName("CNY")
    val CNY: Double,
    @SerializedName("CZK")
    val CZK: Double,
    @SerializedName("DKK")
    val DKK: Double,
    @SerializedName("EUR")
    val EUR: Double,
    @SerializedName("GBP")
    val GBP: Double,
    @SerializedName("HKD")
    val HKD: Double,
    @SerializedName("HUF")
    val HUF: Double,
    @SerializedName("INR")
    val INR: Double,
    @SerializedName("JPY")
    val JPY: Double,
    @SerializedName("KGS")
    val KGS: Double,
    @SerializedName("KRW")
    val KRW: Double,
    @SerializedName("KZT")
    val KZT: Double,
    @SerializedName("MDL")
    val MDL: Double,
    @SerializedName("NOK")
    val NOK: Double,
    @SerializedName("PLN")
    val PLN: Double,
    @SerializedName("RON")
    val RON: Double,
    @SerializedName("RUB")
    val RUB: Double,
    @SerializedName("SEK")
    val SEK: Double,
    @SerializedName("SGD")
    val SGD: Double,
    @SerializedName("TJS")
    val TJS: Double,
    @SerializedName("TMT")
    val TMT: Double,
    @SerializedName("TRY")
    val TRY: Double,
    @SerializedName("UAH")
    val UAH: Double,
    @SerializedName("USD")
    val USD: Double,
    @SerializedName("UZS")
    val UZS: Double,
    @SerializedName("XDR")
    val XDR: Double,
    @SerializedName("ZAR")
    val ZAR: Double
)