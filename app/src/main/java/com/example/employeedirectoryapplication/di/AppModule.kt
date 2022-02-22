package com.example.employeedirectoryapplication.di

import android.app.Application
import androidx.room.Room
import com.example.employeedirectoryapplication.api.EmployeeDirectory
import com.example.employeedirectoryapplication.data.EmployeeDirectoryDao
import com.example.employeedirectoryapplication.data.EmployeeDirectoryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideRetrofit():Retrofit=
        Retrofit.Builder()
            .baseUrl(EmployeeDirectory.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideEmployeeDirectoryApi(retrofit: Retrofit):EmployeeDirectory=
        retrofit.create(EmployeeDirectory::class.java)

    fun provideOfflineData(app:Application):EmployeeDirectoryDatabase=
        Room.databaseBuilder(app,EmployeeDirectoryDatabase::class.java,"employee_databse")
            .build()



}