package ru.trubin23.lifecycle.first_activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class MyServer implements LifecycleObserver {

    private static final String TAG = MyServer.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        //Log.d(TAG, "Lifecycle.Event.ON_START");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {
        //Log.d(TAG, "Lifecycle.Event.ON_STOP");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny(LifecycleOwner source, Lifecycle.Event event) {
        Log.d(TAG, "Lifecycle.Event.ON_ANY: " + event);
    }
}
