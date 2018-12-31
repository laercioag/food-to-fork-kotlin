package com.laercioag.foodtofork.di.component

import com.laercioag.foodtofork.di.module.AppModule
import com.laercioag.foodtofork.di.module.DataModule
import com.laercioag.foodtofork.di.module.DomainModule
import com.laercioag.foodtofork.di.module.PresenterModule
import com.laercioag.foodtofork.di.module.ViewModule
import com.laercioag.foodtofork.presentation.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        AppModule::class,
        DataModule::class,
        DomainModule::class,
        ViewModule::class,
        PresenterModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}
