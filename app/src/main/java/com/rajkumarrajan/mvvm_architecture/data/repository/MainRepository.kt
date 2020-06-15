package com.rajkumarrajan.mvvm_architecture.data.repository

import com.rajkumarrajan.mvvm_architecture.data.api.ApiHelper
import com.rajkumarrajan.mvvm_architecture.data.model.Customer
import com.rajkumarrajan.mvvm_architecture.data.model.User
import io.reactivex.Single
//STEP 5
//now the data is ready
//Set up UI layer, build and run the project

//Create package - ui
//
//Create package - main inside the ui package
//
//Create package - view inside the main package
//
//Move the MainActivity to the view package
//
//Create package - viewmodel inside the main package

class MainRepository(private val apiHelper: ApiHelper) {

    fun getUsers(): Single<List<User>> {
        return apiHelper.getUsers()
    }


}