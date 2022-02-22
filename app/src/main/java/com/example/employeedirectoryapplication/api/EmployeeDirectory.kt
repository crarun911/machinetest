package com.example.employeedirectoryapplication.api

import retrofit2.Response
import retrofit2.http.GET

interface EmployeeDirectory {

    companion object{

        const val BASE_URL="http://www.mocky.io/"
    }

    @GET("v2/5d565297300000680030a986")
    suspend fun getAllEmployees():List<EmployeeItem>
}