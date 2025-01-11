package com.example.cardinfo.ui.cardHistory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binapp.ui.history.CardHistoryState
import com.example.cardinfo.domain.api.DatabaseInteractor
import com.example.cardinfo.domain.model.CardInfo
import kotlinx.coroutines.launch

class CardHistoryViewModel(
    private val databaseInteractor: DatabaseInteractor,
) : ViewModel() {

    private val _screenState = MutableLiveData<CardHistoryState>()
    val screenState: LiveData<CardHistoryState>
        get() = _screenState

    private val _data = MutableLiveData<List<CardInfo>>()
    val data: LiveData<List<CardInfo>>
        get() = _data

    init {
        getSearchHistory()
    }

    fun getSearchHistory() {
        viewModelScope.launch {

            databaseInteractor.getAll().collect { history ->
                _data.value = history
                _screenState.value = if (history.isEmpty()) {
                    CardHistoryState.Empty
                } else {
                    CardHistoryState.Content
                }
            }
        }
    }

    fun deleteCardInfo(cardInfo: CardInfo) {
        viewModelScope.launch {
            databaseInteractor.delete(cardInfo)
        }
    }
}