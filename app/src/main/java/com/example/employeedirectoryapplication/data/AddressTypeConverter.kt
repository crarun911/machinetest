package com.example.employeedirectoryapplication.data

import androidx.room.TypeConverter
import com.example.employeedirectoryapplication.api.Address
import com.google.gson.Gson

class AddressTypeConverter {

    @TypeConverter
    fun appToString(app: Address): String = Gson().toJson(app)

    @TypeConverter
    fun stringToApp(string: String): Address = Gson().fromJson(string, Address::class.java)
}