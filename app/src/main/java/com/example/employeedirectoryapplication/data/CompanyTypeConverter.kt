package com.example.employeedirectoryapplication.data

import androidx.room.TypeConverter
import com.example.employeedirectoryapplication.api.Address
import com.example.employeedirectoryapplication.api.Company
import com.google.gson.Gson

class CompanyTypeConverter {
    @TypeConverter
    fun appToString(app: Company): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Company = Gson().fromJson(string, Company::class.java)
}