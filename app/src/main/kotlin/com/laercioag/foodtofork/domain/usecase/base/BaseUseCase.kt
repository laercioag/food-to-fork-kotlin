package com.laercioag.foodtofork.domain.usecase.base

abstract class BaseUseCase<out T> {

    protected abstract fun run(): T

    operator fun invoke(): T = run()
}
