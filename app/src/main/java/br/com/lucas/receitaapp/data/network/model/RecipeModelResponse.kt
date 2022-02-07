package br.com.lucas.receitaapp.data.network.model

import com.google.gson.annotations.SerializedName

data class RecipeModelResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("viewStatus") var viewStatus: Int? = null,
    @SerializedName("favorite") var favorite: Boolean? = null,
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("video") var video: String? = null,
    @SerializedName("categoryName") var categoryName: String? = null,
    @SerializedName("ingredients") var ingredients: String? = null,
    @SerializedName("methodOfPrepare") var methodOfPrepare: String? = null,
    @SerializedName("shortName") var shortName: String? = null,
    @SerializedName("language") var language: String? = null,
    @SerializedName("keywords") var keywords: String? = null,
    @SerializedName("publicationDate") var publicationDate: String? = null,
    @SerializedName("healthy") var healthy: Boolean? = null,
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("__v") var _v: Int? = null,
    @SerializedName("notificationId") var notificationId: String? = null
)