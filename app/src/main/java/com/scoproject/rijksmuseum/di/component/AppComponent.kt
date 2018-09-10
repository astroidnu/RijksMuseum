package com.scoproject.rijksmuseum.di.component

import android.app.Application
import com.scoproject.base.di.scope.AppScope
import com.scoproject.rijksmuseum.RiskMuseumApp
import com.scoproject.rijksmuseum.di.module.AppModule
import com.scoproject.rijksmuseum.di.module.builder.ActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
@AppScope
@Component(modules = [
    (AndroidInjectionModule::class),
    (AppModule::class),
    (ActivityBuilder::class)
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: RiskMuseumApp)
}