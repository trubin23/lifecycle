package ru.trubin23.lifecycle.fourth_activity;

class Repository {

    private static Repository INSTANCE;

    private Repository() {
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public void getData(Callback callback) {
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
    }

    interface Callback {
        void onSuccess(String result);

        void onError();
    }
}
