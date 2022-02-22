package com.example.employeedirectoryapplication.api

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "employee_table")
data class EmployeeItem(
    @PrimaryKey val id: Int,
    val address: Address,
    val company: Company,
    val email: String,
    val name: String,
    val phone: String,
    val profile_image: String,
    val username: String,
    val website: String
)