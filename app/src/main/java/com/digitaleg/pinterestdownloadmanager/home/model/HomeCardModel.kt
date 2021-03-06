package com.digitaleg.pinterestdownloadmanager.home.model

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName

@Generated("com.robohorse.robopojogenerator")
data class HomeCardModel(

        @field:SerializedName("urls")
	val urls: Urls? = null,

        @field:SerializedName("current_user_collections")
	val currentUserCollections: List<Any?>? = null,

        @field:SerializedName("color")
	val color: String? = null,

        @field:SerializedName("width")
	val width: Int? = null,

        @field:SerializedName("created_at")
	val createdAt: String? = null,

        @field:SerializedName("links")
	val links: Links? = null,

        @field:SerializedName("id")
	val id: String? = null,

        @field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

        @field:SerializedName("liked_by_user")
	val likedByUser: Boolean? = null,

        @field:SerializedName("user")
	val user: User? = null,

        @field:SerializedName("height")
	val height: Int? = null,

        @field:SerializedName("likes")
	val likes: Int? = null
)