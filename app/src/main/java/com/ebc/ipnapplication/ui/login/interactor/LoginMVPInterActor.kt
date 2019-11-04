package com.ebc.ipnapplication.ui.login.interactor

import com.ebc.ipnapplication.data.network.LoginResponse
import com.ebc.ipnapplication.data.database.repository.post.Post
import com.ebc.ipnapplication.ui.base.interactor.MVPInterActor
import io.reactivex.Observable

interface LoginMVPInterActor : MVPInterActor {
    fun doServerLoginApiCall(email: String, password: String): Observable<LoginResponse>
    fun loadUserPosts(): Observable<List<Post>>
    fun seedPosts(questions: List<Post>): Observable<Boolean>
    fun getPost():  Observable<List<Post>>

}
