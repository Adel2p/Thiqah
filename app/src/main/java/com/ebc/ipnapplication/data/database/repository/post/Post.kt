package com.ebc.ipnapplication.data.database.repository.post

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts")
data class Post(
    @Expose
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @Expose
    @ColumnInfo(name = "user_id")
    @SerializedName("userId") val userId: Int,
    @Expose
    @ColumnInfo(name = "post_title")
    @SerializedName("title") val title: String,
    @Expose
    @ColumnInfo(name = "post_body")
    @SerializedName("body") val body: String
)
