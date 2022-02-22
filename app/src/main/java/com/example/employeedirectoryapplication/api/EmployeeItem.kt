package com.example.employeedirectoryapplication.api

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "employee_table")
@Parcelize
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
):Parcelable