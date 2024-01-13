package ru.com.bulat.courutineflowsoumin.crypto_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class CryptoViewModel : ViewModel() {

    private val repository = CryptoRepository

    val state: LiveData<State> = repository.getCurrencyList()
        .filter { it.isNotEmpty() }
        .map { State.Content(currencyList = it) as State }
        .onStart {
            Log.d("AAA", "onStart")
            emit(State.Loading)
        }
        .onEach {
            Log.d("AAA", "onEach")
        }
        .onCompletion {cause: Throwable? ->
            Log.d("AAA", "onCompletion")
        }
        .asLiveData()
}