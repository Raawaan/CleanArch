package com.example.domain.interactor

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.*

abstract class ObservableUseCase<T,in E>(val scheduler: Scheduler){
    private val disposables:CompositeDisposable=CompositeDisposable()
    protected abstract fun buildUseCaseObservable(params:E?=null):Observable<T>
    open fun execute(observer: DisposableObserver<T>,params: E?=null){
        val observable=this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(scheduler)
        addDisposable(observable.subscribeWith(observer))
    }
    fun dispose(){
        disposables.dispose()
    }
    private fun addDisposable(disposable: Disposable){
        disposables.add(disposable)
    }

}