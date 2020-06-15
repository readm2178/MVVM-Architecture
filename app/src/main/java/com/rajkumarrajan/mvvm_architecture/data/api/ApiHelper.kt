package com.rajkumarrajan.mvvm_architecture.data.api

//step 4
//then REPOSITORY ----> MAINREP

class ApiHelper(private val apiService: ApiService) {
    fun getUsers() = apiService.getUsers()
    fun getCustomers()=apiService.getCustomers()
}