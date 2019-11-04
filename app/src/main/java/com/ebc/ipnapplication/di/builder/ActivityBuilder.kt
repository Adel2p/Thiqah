package com.ebc.ipnapplication.di.builder

import com.ebc.ipnapplication.ui.login.view.LoginActivity
import com.ebc.ipnapplication.ui.login.LoginActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
    abstract fun bindLoginActivity(): LoginActivity
}