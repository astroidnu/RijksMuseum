package com.scoproject.rijksmuseum.features.registration.di

import com.scoproject.base.data.model.UserModel
import com.scoproject.base.di.scope.ActivityScope
import com.scoproject.base.presentation.ui.router.ScreenRouter
import com.scoproject.rijksmuseum.external.Helper
import com.scoproject.rijksmuseum.features.registration.domain.RegistrationRouter
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationActivity
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationContract
import com.scoproject.rijksmuseum.features.registration.presentation.RegistrationPresenter
import com.tunaikumobile.base.data.session.LoginSession
import dagger.Module
import dagger.Provides

/**
 * Created by ibnumuzzakkir on 10/09/18.
 * Mobile Engineer
 */
@Module
class RegistrationModule {
    @Provides
    @ActivityScope
    internal fun provideActivity(activity: RegistrationActivity): RegistrationContract.View {
        return activity
    }

    @Provides
    @ActivityScope
    fun provideRouter(screen: ScreenRouter, activity: RegistrationActivity) = RegistrationRouter(screen, activity)


    @Provides
    @ActivityScope
    internal fun provideRegistrationPresenter(userModel: UserModel,
                                              router: RegistrationRouter,
                                              helper: Helper,
                                              loginSession: LoginSession) =
            RegistrationPresenter(userModel,
                    router,
                    helper,
                    loginSession)
}