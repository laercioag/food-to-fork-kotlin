package com.laercioag.foodtofork.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter<V : BaseView> {

    private val compositeDisposable = CompositeDisposable()

    abstract fun attach(view: V)

    open fun detach() {
        compositeDisposable.clear()
    }

    protected fun Disposable.disposeOnDetach() {
        compositeDisposable.add(this)
    }
}
