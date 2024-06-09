package com.example.swaraapp.ui.bisara

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.swaraapp.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BisaraActivity : AppCompatActivity() {

    private lateinit var adapter: EventAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bisara)

        val backButton: ImageView = findViewById(R.id.backButton)
        val searchView: SearchView = findViewById(R.id.searchView)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val buttonAll: Button = findViewById(R.id.button_all)
        val buttonCompetition: Button = findViewById(R.id.button_competition)
        val buttonEvent: Button = findViewById(R.id.button_event)
        val buttonVolunteer: Button = findViewById(R.id.button_volunteer)
        val buttonArt: Button = findViewById(R.id.button_art)

        recyclerView.layoutManager = GridLayoutManager(this, 2)
        adapter = EventAdapter(emptyList())
        recyclerView.adapter = adapter

        fetchEvents()

        backButton.setOnClickListener {
            finish() // Handle back button click
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search query submit
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle search query text change
                return false
            }
        })

        buttonAll.setOnClickListener {
            // Handle All button click
        }

        buttonCompetition.setOnClickListener {
            // Handle Competition button click
        }

        buttonEvent.setOnClickListener {
            // Handle Event button click
        }

        buttonVolunteer.setOnClickListener {
            // Handle Volunteer button click
        }

        buttonArt.setOnClickListener {
            // Handle Art button click
        }
    }

    private fun fetchEvents() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://your.api.url/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
        apiService.getEvents().enqueue(object : Callback<List<Event>> {
            override fun onResponse(call: Call<List<Event>>, response: Response<List<Event>>) {
                if (response.isSuccessful) {
                    val events = response.body() ?: emptyList()
                    adapter.updateEvents(events)
                }
            }

            override fun onFailure(call: Call<List<Event>>, t: Throwable) {
                // Handle API call failure
            }
        })
    }
}
