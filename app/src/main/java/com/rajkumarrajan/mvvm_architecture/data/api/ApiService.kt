package com.rajkumarrajan.mvvm_architecture.data.api

import com.rajkumarrajan.mvvm_architecture.data.model.Customer
import com.rajkumarrajan.mvvm_architecture.data.model.User
import io.reactivex.Single
import retrofit2.http.GET

//step 3 get the user as list
interface ApiService {
    @GET("users")
    fun getUsers(): Single<List<User>>
    @GET("customers")
    fun getCustomers():Single<List<Customer>>
}