package com.example.jetpackapp_01

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    var quoteList  = listOf( QuoteModel("sd","asda"),QuoteModel("sd","asda"),QuoteModel("sd","asda"))
    var index = 0

    var quoteLiveData  = MutableLiveData<String>("test value new dta ")

    fun getQuote() = quoteList[index]

    fun  nextQuote() = quoteList[++index]

    fun prevQuote()= quoteList[--index]

    fun updateLiveData(){
        quoteLiveData.value = " another live data update data "
    }

}