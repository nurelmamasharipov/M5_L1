package com.example.m5_l1

import androidx.core.graphics.toColorInt

class CounterPresenter {
    private val model = CounterModel()
    private var view: CounterView? = null

    fun attachView(view: CounterView) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun increment() {
        model.increment()
        val result = model.getResult()
        view?.showResult(result)

        if (result == 10) {
            view?.showToast("Поздравляем")
        }
        view?.greenText(result == 15)
    }

    fun decrement() {
        model.decrement()
        val result = model.getResult()
        view?.showResult(model.getResult())
        if (model.getResult() == 10) {
            view?.showToast("Поздравляем")
        }
        view?.greenText(result == 15)
    }
}
