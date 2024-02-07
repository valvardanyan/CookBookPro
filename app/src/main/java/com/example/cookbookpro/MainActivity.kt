package com.example.cookbookpro

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cookbookpro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: IngredientsAdapter
    private var ingredients: List<Ingredient> = listOf() // The ingredient list
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        recyclerView = findViewById(R.id.ingredientsRecyclerView) //find the view from the xml
        recyclerView.layoutManager = LinearLayoutManager(this) //set a layout manager

        //Create a list of ingredients to display
        ingredients = listOf(
            Ingredient("Tomato", 2.0, "pcs"),
            Ingredient("Salt", 1.0, "tbsp")
        )

        adapter = IngredientsAdapter(ingredients) //find the custom adapter
        recyclerView.adapter = adapter //set the custom adapater to the view
    }
}