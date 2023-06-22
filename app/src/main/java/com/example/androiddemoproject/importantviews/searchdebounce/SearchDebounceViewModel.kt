package com.example.androiddemoproject.importantviews.searchdebounce

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class SearchDebounceViewModel : ViewModel() {
    fun filterPeople(query: String?) {
        if (query != null) {
            _searchText.value = query
        }
    }

    private val _people = MutableStateFlow(getAllPeople())
    @OptIn(FlowPreview::class)
    val people get() = searchText
        .debounce(1000)
        .onEach { _isSearching.update { true } }
        .combine(_people) { query, people ->
            if (query.isBlank()) {
                people
            } else {
                delay(2000)
                people.filter { it.doesMatchSearchQuery(query) }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(10_000),
            _people.value
        )

    private val _searchText = MutableStateFlow("")
    val searchText get() = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching get() = _isSearching.asStateFlow()
}