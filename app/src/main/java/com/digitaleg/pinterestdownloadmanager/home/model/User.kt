package com.digitaleg.pinterestdownloadmanager.home.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class User(

        @field:SerializedName("profile_image")
	val profileImage: ProfileImage? = null,

        @field:SerializedName("name")
	val name: String? = null,

        @field:SerializedName("links")
	val links: Links? = null,

        @field:SerializedName("id")
	val id: String? = null,

        @field:SerializedName("username")
	val username: String? = null
)