package com.ebc.ipnapplication.data.network

import com.ebc.ipnapplication.data.database.repository.post.Post
import io.reactivex.Observable

interface ApiHelper{
    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

    fun getBlogApiCall(): Observable<BlogResponse>

    fun getOpenSourceApiCall(): Observable<OpenSourceResponse>

    fun loadUserPosts(): Observable<List<Post>>

}

