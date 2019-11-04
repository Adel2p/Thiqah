package com.ebc.ipnapplication.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ebc.ipnapplication.data.database.AppDatabase
import com.ebc.ipnapplication.data.database.repository.options.OptionsRepo
import com.ebc.ipnapplication.data.database.repository.options.OptionsRepository
import com.ebc.ipnapplication.data.database.repository.post.PostRepo
import com.ebc.ipnapplication.data.database.repository.post.PostRepository
import com.ebc.ipnapplication.data.database.repository.questions.QuestionRepo
import com.ebc.ipnapplication.data.database.repository.questions.QuestionRepository
import com.ebc.ipnapplication.data.network.ApiHeader
import com.ebc.ipnapplication.data.network.ApiHelper
import com.ebc.ipnapplication.data.network.AppApiHelper
import com.ebc.ipnapplication.data.preferences.AppPreferenceHelper
import com.ebc.ipnapplication.data.preferences.PreferenceHelper
import com.ebc.ipnapplication.di.ApiKeyInfo
import com.ebc.ipnapplication.di.PreferenceInfo
import com.ebc.ipnapplication.utils.extension.AppConstants
import com.ebc.ipnapplication.utils.extension.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by Mohamed Adel on 05/01/18.
 */
@Module
class AppModule {
    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppConstants.APP_DB_NAME).build()

    @Provides
    @ApiKeyInfo
    internal fun provideApiKey(): String = "Test"

    @Provides
    @PreferenceInfo
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME

    @Provides
    @Singleton
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper

    @Provides
    @Singleton
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
        userId = preferenceHelper.getCurrentUserId(),
        accessToken = preferenceHelper.getAccessToken())

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo = QuestionRepository(appDatabase.questionsDao())

    @Provides
    @Singleton
    internal fun provideOptionsRepoHelper(appDatabase: AppDatabase): OptionsRepo = OptionsRepository(appDatabase.optionsDao())

    @Provides
    @Singleton
    internal fun providePostRepoHelper(appDatabase: AppDatabase): PostRepo = PostRepository(appDatabase.postsDao())

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}