package com.ebc.ipnapplication.data.database.repository.post

import io.reactivex.Observable

interface PostRepo {

    fun isPostRepoEmpty(): Observable<Boolean>

    fun insertPosts(posts: List<Post>): Observable<Boolean>

    fun loadPosts(): Observable<List<Post>>
}