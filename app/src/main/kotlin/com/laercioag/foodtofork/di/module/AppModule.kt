package com.laercioag.foodtofork.di.module

import android.content.Context
import com.laercioag.foodtofork.presentation.app.App
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(app: App): Context = app.applicationContext

}
