package ru.trubin23.lifecycle.fifth_activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.trubin23.lifecycle.R;

public class MessengerFragment extends Fragment {

    private static final String FRAGMENT_ID = "FRAGMENT_ID";

    SharedViewModel mSharedViewModel;

    public static MessengerFragment newInstance(int id) {
        MessengerFragment myFragment = new MessengerFragment();

        Bundle args = new Bundle();
        args.putInt(FRAGMENT_ID, id);
        myFragment.setArguments(args);

        return myFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_messenger, container, false);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
