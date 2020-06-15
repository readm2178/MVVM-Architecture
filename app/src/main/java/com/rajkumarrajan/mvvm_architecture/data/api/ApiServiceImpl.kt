package com.rajkumarrajan.mvvm_architecture.data.api

import com.rajkumarrajan.mvvm_architecture.data.model.Customer
import com.rajkumarrajan.mvvm_architecture.data.model.User
import io.reactivex.Single
//step 4
//Implement the Api service interface in to this class and get instance of the retrofit

class ApiServiceImpl : ApiService {
    private val apiService = RetrofitInstance.createService(ApiService::class.java)
    private val apiService2 = RetrofitInstance.createService2(ApiService::class.java)

    override fun getUsers(): Single<List<User>> {
        return apiService.getUsers()
    }
//Automatic Override
    override fun getCustomers(): Single<List<Customer>> {
        return apiService2.getCustomers();
    }
}