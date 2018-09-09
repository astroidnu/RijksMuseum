package com.scoproject.rijksmuseum

import android.app.Activity
import android.support.multidex.MultiDexApplication
import com.scoproject.rijksmuseum.di.component.AppComponent
import com.scoproject.rijksmuseum.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
class RiskMuseumApp : MultiDexApplication(), HasActivityInjector {
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        //Create App Component
        appComponent = createComponent()
        appComponent.inject(this)
    }

    /**
     * Initialize Dependency Injection With Dagger
     * Level DI Application
     * */


    private fun createComponent(): AppComponent {
        return DaggerAppComponent.builder()
                .application(this)
                .build()
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }
}