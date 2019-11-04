package com.ebc.ipnapplication.di.component

import android.app.Application
import com.ebc.ipnapplication.IpnApp
import com.ebc.ipnapplication.di.builder.ActivityBuilder
import com.ebc.ipnapplication.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Created by Mohamed Adel on 05/01/18.
 */
@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ActivityBuilder::class)])
interface AppComponent  {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: IpnApp)

}