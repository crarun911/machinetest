package com.example.employeedirectoryapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.employeedirectoryapplication.api.EmployeeItem


@Database(entities = [EmployeeItem::class], version = 1,exportSchema = false)
@TypeConverters(AddressTypeConverter::class,CompanyTypeConverter::class)
abstract class EmployeeDirectoryDatabase:RoomDatabase() {

    abstract fun getEmployeeDao():EmployeeDirectoryDao
}