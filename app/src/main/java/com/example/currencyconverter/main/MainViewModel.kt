package com.example.currencyconverter.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.data.models.Rates
import com.example.currencyconverter.util.DispatcherProvider
import com.example.currencyconverter.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.math.round
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    sealed class CurrencyEvent {
        class Success(val resultText: String): CurrencyEvent()
        class Failure(val errorText: String): CurrencyEvent()
        object Loading : CurrencyEvent()
        object Empty : CurrencyEvent()
    }

    private val _conversion = MutableStateFlow<CurrencyEvent>(CurrencyEvent.Empty)
    val conversion: StateFlow<CurrencyEvent> = _conversion

    fun convert(
        amountStr: String,
        fromCurrency: String,
        toCurrency: String
    ) {
        val fromAmount = amountStr.toFloatOrNull()
        if (fromAmount == null) {
            _conversion.value = CurrencyEvent.Failure("Not a valid amount")
            return
        }

        viewModelScope.launch(dispatchers.io) {
            _conversion.value = CurrencyEvent.Loading
            when(val ratesResponse = repository.getRates(fromCurrency)) {
                is Resource.Error -> _conversion.value = CurrencyEvent.Failure(ratesResponse.message!!)
                is Resource.Success -> {
                    val rates = ratesResponse.data!!.rates
                    val rate = getRateForCurrency(toCurrency, rates)
                    if(rate == null) {
                        _conversion.value = CurrencyEvent.Failure("Unexpected error")
                    } else {
                        val convertedCurrency = round(fromAmount * rate * 100) / 100
                        _conversion.value = CurrencyEvent.Success(
                            "$fromAmount $fromCurrency = $convertedCurrency $toCurrency"
                        )
                    }
                }
            }
        }
    }

    private fun getRateForCurrency(currency: String, rates: Rates) = when (currency) {
        "AMD" -> rates.AMD
        "AUD" -> rates.AUD
        "AZN" -> rates.AZN
        "BGN" -> rates.BGN
        "BRL" -> rates.BRL
        "BYN" -> rates.BYN
        "CAD" -> rates.CAD
        "CHF" -> rates.CHF
        "CNY" -> rates.CNY
        "CZK" -> rates.CZK
        "DKK" -> rates.DKK
        "EUR" -> rates.EUR
        "GBP" -> rates.GBP
        "HKD" -> rates.HKD
        "HUF" -> rates.HUF
        "INR" -> rates.INR
        "JPY" -> rates.JPY
        "KGS" -> rates.KGS
        "KRW" -> rates.KRW
        "KZT" -> rates.KZT
        "MDL" -> rates.MDL
        "NOK" -> rates.NOK
        "PLN" -> rates.PLN
        "RON" -> rates.RON
        "RUB" -> rates.RUB
        "SEK" -> rates.SEK
        "SGD" -> rates.SGD
        "TJS" -> rates.TJS
        "TMT" -> rates.TMT
        "TRY" -> rates.TRY
        "UAH" -> rates.UAH
        "USD" -> rates.USD
        "UZS" -> rates.UZS
        "XDR" -> rates.XDR
        "ZAR" -> rates.ZAR

        else -> null
    }
}