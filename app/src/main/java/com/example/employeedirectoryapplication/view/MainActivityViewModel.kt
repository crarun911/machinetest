package com.example.employeedirectoryapplication.view

import androidx.lifecycle.*
import com.example.employeedirectoryapplication.api.Employee
import com.example.employeedirectoryapplication.api.EmployeeDirectory
import com.example.employeedirectoryapplication.api.EmployeeItem
import com.example.employeedirectoryapplication.data.EmployeeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainActivityViewModel @Inject constructor(
    repository: EmployeeRepository
):ViewModel() {

   val employee=repository.getAllEmployees().asLiveData()
}