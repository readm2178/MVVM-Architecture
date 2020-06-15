package com.rajkumarrajan.mvvm_architecture.data.model

import com.google.gson.annotations.SerializedName

data class Customer(

    @field:SerializedName("avatar_url")
    val avatar: String? = null
)
