package com.ebc.ipnapplication.ui.base.presenter

import com.ebc.ipnapplication.ui.base.interactor.MVPInterActor
import com.ebc.ipnapplication.ui.base.view.MVPView
import com.ebc.ipnapplication.utils.extension.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Mohamed Adel on 04/01/18.
 */
abstract class BasePresenter<V : MVPView, I : MVPInterActor> internal constructor(protected var interactor: I?, protected val schedulerProvider: SchedulerProvider, protected val compositeDisposable: CompositeDisposable) :
    MVPPresenter<V, I> {

    private var view: V? = null
    private val isViewAttached: Boolean get() = view != null

    override fun onAttach(view: V?) {
        this.view = view
    }

    override fun getView(): V? = view

    override fun onDetach() {
        compositeDisposable.dispose()
        view = null
        interactor = null
    }

}