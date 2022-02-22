package com.example.employeedirectoryapplication.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.employeedirectoryapplication.api.EmployeeItem
import com.example.employeedirectoryapplication.databinding.ActivityDetailBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val employee: EmployeeItem? = intent?.getParcelableExtra("data")
        binding.apply {
            Glide.with(this@DetailActivity)
                .load(employee?.profile_image)
                .into(imageViewEmployee)
            textViewName.text=employee?.name
            textViewUserName.text=employee?.username
            textViewEmailAddress.text=employee?.email
            textViewAddress.text=employee?.address?.city
            textViewPhone.text=employee?.phone
            textViewWebsite.text=employee?.website
            textViewcompanyDetails.text=employee?.company?.name

        }
    }
}