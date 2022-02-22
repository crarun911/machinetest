package com.example.employeedirectoryapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.employeedirectoryapplication.api.EmployeeItem


@Database(entities = [EmployeeItem::class], version = 1)
abstract class EmployeeDirectoryDatabase:RoomDatabase() {

    abstract fun getEmployeeDao():EmployeeDirectoryDao
}