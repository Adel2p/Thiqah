package com.ebc.ipnapplication.data.database.repository.post

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PostsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(post: List<Post>)

    @Query("SELECT * FROM posts")
    fun loadAll(): List<Post>
}