package com.digitaleg.pinterestdownloadmanager.home.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class CategoriesItem(

        @field:SerializedName("photo_count")
	val photoCount: Int? = null,

        @field:SerializedName("links")
	val links: Links? = null,

        @field:SerializedName("id")
	val id: Int? = null,

        @field:SerializedName("title")
	val title: String? = null
)