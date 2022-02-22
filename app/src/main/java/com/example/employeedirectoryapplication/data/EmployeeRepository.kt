package com.example.employeedirectoryapplication.data

import androidx.room.withTransaction
import com.example.employeedirectoryapplication.api.EmployeeDirectory
import com.example.employeedirectoryapplication.util.networkBoundResource
import javax.inject.Inject

class EmployeeRepository @Inject constructor(
        private val api:EmployeeDirectory,
        private val db:EmployeeDirectoryDatabase
) {
    private val employeeDirectoryDao=db.getEmployeeDao()

    fun getAllEmployees() = networkBoundResource(
    query = {
        employeeDirectoryDao.getAllEmployee()
    },
    fetch = {
        api.getAllEmployees()
    },
    saveFetchResult = { employee ->
        db.withTransaction {
            employeeDirectoryDao.insertEmployees(employee)
        }
    }
    )
}