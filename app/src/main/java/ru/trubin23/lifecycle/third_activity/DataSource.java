package ru.trubin23.lifecycle.third_activity;


import android.arch.lifecycle.MutableLiveData;

class DataSource {

    private static DataSource INSTANCE;

    private DataSource() {
    }

    static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();



        }
        return INSTANCE;
    }

    private class MyThread extends Thread{

        private MutableLiveData mMutableLiveData;
        private String mDescription;
        private int mSleepTime;

        MyThread(MutableLiveData<String> mutableLiveData, String description, int sleepTime){
            mMutableLiveData = mutableLiveData;
            mDescription = description;
            mSleepTime = sleepTime;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                mMutableLiveData.postValue(mDescription);

                try {
                    Thread.sleep(mSleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
