package com.example.employeedirectoryapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeedirectoryapplication.api.EmployeeItem
import com.example.employeedirectoryapplication.databinding.ActivityMainBinding
import com.example.employeedirectoryapplication.util.Resource
import com.example.employeedirectoryapplication.view.DetailActivity
import com.example.employeedirectoryapplication.view.EmployeeAdapter
import com.example.employeedirectoryapplication.view.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), EmployeeAdapter.onItemClick {
    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val employeeAdapter = EmployeeAdapter(this)
        binding.apply {
            recyclerView.apply {
                adapter = employeeAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
            viewModel.employee.observe(this@MainActivity) { resource ->

                employeeAdapter.submitList(resource.data)
                progressBar.isVisible = resource is Resource.Loading
                textViewError.isVisible = resource is Resource.Error
                textViewError.text = resource.error?.localizedMessage
            }
        }
    }

    override fun onItemClick(item: EmployeeItem) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra("data", item)
        }
        startActivity(intent)

    }
}