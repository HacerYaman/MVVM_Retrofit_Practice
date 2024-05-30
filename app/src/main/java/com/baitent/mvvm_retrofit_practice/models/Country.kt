package com.baitent.mvvm_retrofit_practice.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*data class Country(
    val countryName: String?,
    val countryRegion: String?,
    val imageUrl: String?) */

//API için configlenmiş model
/*data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("region")
    val countryRegion: String?,
    @SerializedName("imageurl")
    val imageUrl: String?
)*/

//ROOM config

@Entity
data class Country(

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val countryName: String?,

    @ColumnInfo(name = "region")
    @SerializedName("region")
    val countryRegion: String?,

    @ColumnInfo(name = "imageurl")
    @SerializedName("imageurl")
    val imageUrl: String?
){
    @PrimaryKey(autoGenerate = true)
    var uuid: Int=0

}


