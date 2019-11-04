package com.ebc.ipnapplication.ui.login

import androidx.recyclerview.widget.LinearLayoutManager
import com.ebc.ipnapplication.ui.login.interactor.LoginInterActor
import com.ebc.ipnapplication.ui.login.interactor.LoginMVPInterActor
import com.ebc.ipnapplication.ui.login.presenter.LoginMVPPresenter
import com.ebc.ipnapplication.ui.login.presenter.LoginPresenter
import com.ebc.ipnapplication.ui.login.view.LoginActivity
import com.ebc.ipnapplication.ui.login.view.LoginMVPView
import com.ebc.ipnapplication.ui.login.view.PostsAdapter
import dagger.Module
import dagger.Provides
import java.util.ArrayList
import javax.inject.Inject

@Module
class LoginActivityModule {
    @Provides
    internal fun provideLoginInterActor(interActor: LoginInterActor): LoginMVPInterActor =
        interActor

    @Provides
    internal fun provideLoginPresenter(presenter: LoginPresenter<LoginMVPView, LoginMVPInterActor>)
            : LoginMVPPresenter<LoginMVPView, LoginMVPInterActor> = presenter

    @Provides
    internal fun providePostAdapter(): PostsAdapter = PostsAdapter(ArrayList())

    @Provides
    internal fun provideLinearLayoutManager(activity: LoginActivity): LinearLayoutManager =
        LinearLayoutManager(activity)
}