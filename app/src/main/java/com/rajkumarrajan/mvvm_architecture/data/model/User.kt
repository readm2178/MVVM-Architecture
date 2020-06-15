package com.rajkumarrajan.mvvm_architecture.data.model

import com.google.gson.annotations.SerializedName

//Second step ---> According to the json response need to create
//Need to setup the n/w layer for this response in API PACKAGE--->API service

data class User(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("avatar")
	val avatar: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)

