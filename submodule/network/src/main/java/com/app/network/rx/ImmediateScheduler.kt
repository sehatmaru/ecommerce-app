package com.app.network.rx;


import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

class ImmediateScheduler : BaseSchedulerProvider {
    override fun computation(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun io(): Scheduler {
        return Schedulers.trampoline()
    }

    override fun ui(): Scheduler {
        return Schedulers.trampoline()
    }
}
