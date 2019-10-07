package com.scoproject.rijksmuseum

import android.app.Activity
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.scoproject.rijksmuseum.di.component.AppComponent
import com.scoproject.rijksmuseum.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser
import javax.inject.Inject

/**
 * Created by ibnumuzzakkir on 09/09/18.
 * Mobile Engineer
 */
class RijskMuseumApp : MultiDexApplication(), HasActivityInjector {
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    @Inject
    lateinit var mBoxStore: BoxStore

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        //Create App Component
        appComponent = createComponent()
        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            val started = AndroidObjectBrowser(mBoxStore).start(this)
            Log.i("ObjectBrowser", "Started: $started")
        }
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