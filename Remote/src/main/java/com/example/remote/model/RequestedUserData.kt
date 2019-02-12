package com.example.remote.model

import com.google.gson.annotations.SerializedName

data class RequestedUserData(@SerializedName("name")
                                     var name:String,
                                     @SerializedName("id")
                                     var email:String,
                                     @SerializedName("icon")
                                     var icon:String,
                                     @SerializedName("cat")
                                     var category:String)
