package com.example.hackillinoisandroidchallenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hackillinoisandroidchallenge.adapter.ScheduleAdapter
import com.example.hackillinoisandroidchallenge.viewmodel.ScheduleViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Observe ViewModel and update RecyclerView adapter
        viewModel.events.observe(this, Observer { events ->
            recyclerView.adapter = ScheduleAdapter(events)
        })

        // Fetch events from API
        viewModel.fetchEvents()
    }
}

