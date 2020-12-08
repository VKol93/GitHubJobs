package com.vk.githubjobs.model

import com.google.gson.annotations.SerializedName

data class JobPost (
    val type: String,
    val url: String,
    @SerializedName(value = "created_at") val createdAt: String,
    val company: String,
    @SerializedName(value= "company_url") val companyUrl: String,
    val location: String,
    val title: String,
    @SerializedName(value = "company_logo") val companyLogo:String
)