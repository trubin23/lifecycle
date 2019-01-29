package ru.trubin23.lifecycle.third_activity;


import android.arch.lifecycle.MutableLiveData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class DataSource {

    private static DataSource INSTANCE;

    private static final int THREAD_COUNT = 5;

    private List<MyThread> mMyThreadList = new ArrayList<>();
    private String[] mDescriptionArray = {
            "Первый:",
            "Второй:",
            "Третий:",
            "Четвертый:",
            "Пятый:"
    };

    private DataSource() {
    }

    static DataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataSource();

            for (int i=0;i<THREAD_COUNT;i++){
                //MyThread myThread = new MyThread();
            }
        }
        return INSTANCE;
    }
}
