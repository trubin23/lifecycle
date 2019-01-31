package ru.trubin23.lifecycle.fourth_activity;

import android.util.Log;

class Repository {

    private static Repository INSTANCE;

    private Repository() {
    }

    static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    void getData(Callback callback) {
        Log.d(FourthActivity.TAG, "Repository getData");

        Thread thread = new Thread(() -> {
            try {
                int sleepTime = 15_000;
                Thread.sleep(sleepTime);
                callback.onSuccess("success message");
            } catch (InterruptedException e) {
                e.printStackTrace();
                callback.onError();
            }
        });
        thread.start();
    }

    interface Callback {
        void onSuccess(String result);

        void onError();
    }
}
