package com.app.network.rx;


import io.reactivex.Scheduler;

interface BaseSchedulerProvider {
    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}
