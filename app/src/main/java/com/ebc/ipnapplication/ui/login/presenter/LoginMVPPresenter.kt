package com.ebc.ipnapplication.ui.login.presenter

import com.ebc.ipnapplication.ui.base.presenter.MVPPresenter
import com.ebc.ipnapplication.ui.login.interactor.LoginMVPInterActor
import com.ebc.ipnapplication.ui.login.view.LoginMVPView

interface LoginMVPPresenter <V : LoginMVPView, I : LoginMVPInterActor> : MVPPresenter<V, I>{
    fun onServerLoginClicked(email: String, password: String)
    fun loadUserPosts()
    fun loadCachedUserPosts()

}

