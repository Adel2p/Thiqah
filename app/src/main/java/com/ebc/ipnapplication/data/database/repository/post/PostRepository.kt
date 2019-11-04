package com.ebc.ipnapplication.data.database.repository.post

import io.reactivex.Observable
import javax.inject.Inject

class PostRepository @Inject internal constructor(private val postsDao: PostsDao) :
    PostRepo {
    override fun isPostRepoEmpty(): Observable<Boolean> =
        Observable.fromCallable({ postsDao.loadAll().isEmpty() })


    override fun insertPosts(questions: List<Post>): Observable<Boolean> {
        postsDao.insertAll(questions)
        return Observable.just(true)
    }

    override fun loadPosts(): Observable<List<Post>> =
        Observable.fromCallable({ postsDao.loadAll() })

}
