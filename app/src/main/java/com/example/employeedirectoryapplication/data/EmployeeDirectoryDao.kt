package com.example.employeedirectoryapplication.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.employeedirectoryapplication.api.EmployeeItem
import kotlinx.coroutines.flow.Flow


@Dao
interface EmployeeDirectoryDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEmployees(employee:List<EmployeeItem>)

    @Query("SELECT * FROM employee_table")
    fun getAllEmployee(): Flow<List<EmployeeItem>>
}