package com.laercioag.foodtofork.presentation.base

interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun handleError(throwable: Throwable)
}
