package com.example.hackillinoisandroidchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import com.example.hackillinoisandroidchallenge.model.Event
import com.example.hackillinoisandroidchallenge.repository.EventRepository

class ScheduleViewModel : ViewModel() {

    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> get() = _events

    fun fetchEvents() {
        viewModelScope.launch {
            try {
                // Fetch the EventsResponse and then extract the list of events
                val eventsResponse = EventRepository().getEvents()  // Returns EventsResponse
                _events.postValue(eventsResponse.events)  // Access the list of events from EventsResponse
            } catch (e: Exception) {
                // Handle error
            }
        }
    }
}

