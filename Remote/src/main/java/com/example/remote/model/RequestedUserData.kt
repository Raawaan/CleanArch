package com.example.remote.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class RequestedUserData(var name:String,
                                     var id:String,
                                     var icon:String,
                                     var cat:String)
