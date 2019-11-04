package com.ebc.ipnapplication.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ebc.ipnapplication.data.database.repository.options.Options
import com.ebc.ipnapplication.data.database.repository.options.OptionsDao
import com.ebc.ipnapplication.data.database.repository.post.Post
import com.ebc.ipnapplication.data.database.repository.post.PostsDao
import com.ebc.ipnapplication.data.database.repository.questions.Question
import com.ebc.ipnapplication.data.database.repository.questions.QuestionsDao

/**
 * Created by Mohamed Adel on 03/01/18.
 */
@Database(entities = [(Question::class), (Options::class),(Post::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun optionsDao(): OptionsDao

    abstract fun questionsDao(): QuestionsDao

    abstract fun postsDao(): PostsDao

}