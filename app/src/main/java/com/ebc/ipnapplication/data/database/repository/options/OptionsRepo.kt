package com.ebc.ipnapplication.data.database.repository.options

import io.reactivex.Observable
import io.reactivex.Single

/**
 * Created by Mohamed Adel on 06/01/18.
 */
interface OptionsRepo {

    fun isOptionsRepoEmpty(): Observable<Boolean>

    fun insertOptions(options: List<Options>): Observable<Boolean>

    fun loadOptions(questionId: Long): Single<List<Options>>

}