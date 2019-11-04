package com.ebc.ipnapplication.ui.login.presenter

import com.ebc.ipnapplication.ui.base.presenter.BasePresenter
import com.ebc.ipnapplication.ui.login.interactor.LoginMVPInterActor
import com.ebc.ipnapplication.ui.login.view.LoginMVPView
import com.ebc.ipnapplication.utils.extension.AppConstants
import com.ebc.ipnapplication.utils.extension.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LoginPresenter<V : LoginMVPView, I : LoginMVPInterActor> @Inject internal constructor(
    interActor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interActor,
    schedulerProvider = schedulerProvider,
    compositeDisposable = disposable
), LoginMVPPresenter<V, I> {


    override fun loadCachedUserPosts() {
        getCachedPosts()
    }

    override fun onServerLoginClicked(email: String, password: String) {
        when {
            email.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_EMAIL_ERROR)
            password.isEmpty() -> getView()?.showValidationMessage(AppConstants.EMPTY_PASSWORD_ERROR)
            else -> {
                getView()?.showProgress()
                interactor?.let {
                    compositeDisposable.add(
                        it.doServerLoginApiCall(email, password)
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({ loginResponse ->
                                getView()?.openMainActivity()
                            }, { err -> println(err) })
                    )
                }

            }
        }
    }

    private fun getCachedPosts() = interactor?.let {
        compositeDisposable.add(
            it.getPost()
                .compose(schedulerProvider.ioToMainObservableScheduler())
                .subscribe({ posts ->
                    getView()?.let {
                        if (posts.isEmpty()) return@subscribe
                        else it.displayUsersList(posts)
                    }
                }, { err -> println(err) })
        )
    }

    override fun loadUserPosts() {
        getView()?.showProgress()
        interactor?.let {
            compositeDisposable.add(
                it.loadUserPosts()
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ user ->
                        getView()?.let {
                            getView()?.hideProgress()
                            it.displayUsersList(user)
                            interactor!!.seedPosts(user)
                        }
                    }, { err ->
                        getView()?.hideProgress()
                        println(err)
                    })
            )
        }


    }
}
