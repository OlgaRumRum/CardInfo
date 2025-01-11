package com.example.cardinfo.ui.cardSearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cardinfo.domain.api.DatabaseInteractor
import com.example.cardinfo.domain.api.SearchInteractor
import com.example.cardinfo.domain.model.CardInfo
import com.example.cardinfo.domain.model.Resource
import kotlinx.coroutines.launch

class CardSearchViewModel(
    private val searchInteractor: SearchInteractor,
    private val databaseInteractor: DatabaseInteractor
) : ViewModel() {

    private val _screenState = MutableLiveData<CardSearchState>()
    val screenState: LiveData<CardSearchState>
        get() = _screenState

    fun getCardInfo(number: String) {
        viewModelScope.launch {
            val result = searchInteractor.getCardInfo(number)
            successResult(result)
        }
    }

    private fun saveToHistory(cardInfo: CardInfo) {
        viewModelScope.launch {
            databaseInteractor.insert(cardInfo)
        }
    }

    private fun successResult(resource: Resource<CardInfo>) {
        when (resource) {
            is Resource.Success -> {
                saveToHistory(resource.data)
                _screenState.value = CardSearchState.Content(resource.data)
            }

            is Resource.Error -> {
                _screenState.value = CardSearchState.Error(resource.message)
            }
        }
    }
}