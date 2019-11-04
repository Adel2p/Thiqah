package com.ebc.ipnapplication.ui.login.interactor

import android.content.Context
import com.ebc.ipnapplication.data.network.ApiHelper
import com.ebc.ipnapplication.data.network.LoginRequest
import com.ebc.ipnapplication.data.database.repository.post.Post
import com.ebc.ipnapplication.data.database.repository.post.PostRepo
import com.ebc.ipnapplication.data.preferences.PreferenceHelper
import com.ebc.ipnapplication.ui.base.interactor.BaseInterActor
import com.ebc.ipnapplication.utils.extension.AppConstants
import com.ebc.ipnapplication.utils.extension.FileUtils
import com.google.gson.GsonBuilder
import com.google.gson.internal.`$Gson$Types`
import io.reactivex.Observable
import javax.inject.Inject
import io.reactivex.schedulers.Schedulers.single


class LoginInterActor @Inject internal constructor(
    private val mContext: Context,
    private val postRepoHelper: PostRepo,
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInterActor(preferenceHelper, apiHelper), LoginMVPInterActor {

    override fun loadUserPosts(): Observable<List<Post>> =
        apiHelper.loadUserPosts()


    override fun doServerLoginApiCall(email: String, password: String) =
        apiHelper.performServerLogin(
            LoginRequest.ServerLoginRequest(
                email = email,
                password = password
            )
        )

    override fun getPost(): Observable<List<Post>> {

        return postRepoHelper.loadPosts()
    }

    override fun seedPosts(questions: List<Post>): Observable<Boolean> {
        val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation()
        val gson = builder.create()
        return postRepoHelper.isPostRepoEmpty().concatMap { isEmpty ->
            if (isEmpty) {
                val type = `$Gson$Types`.newParameterizedTypeWithOwner(
                    null,
                    List::class.java,
                    Post::class.java
                )

                postRepoHelper.insertPosts(questions)
            } else
                Observable.just(false)
        }
    }
}

