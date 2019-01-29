package ru.trubin23.lifecycle.third_activity;


import android.arch.lifecycle.MediatorLiveData;

class DataSource {

    private static DataSource INSTANCE;

    private static MediatorLiveData<String> sMediatorLiveData = new MediatorLiveData<>();

    private DataSource() {
    }

    static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();

            int threadCount = 5;

            String[] descriptionArray = {
                    "Первый:",
                    "Второй:",
                    "Третий:",
                    "Четвертый:",
                    "Пятый:"
            };

            int sleepTime = 100;
            for (int i = 0; i < threadCount; i++) {
                MyThread myThread = new MyThread(descriptionArray[i], sleepTime);
                myThread.start();

                sleepTime = (int) (sleepTime * 1.51f);

                sMediatorLiveData.addSource(myThread.getLiveData(),
                        s -> sMediatorLiveData.setValue(s));
            }
        }
        return INSTANCE;
    }

    MediatorLiveData<String> getMediatorLiveData() {
        return sMediatorLiveData;
    }
}
