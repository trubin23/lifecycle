package ru.trubin23.lifecycle.fifth_activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import ru.trubin23.lifecycle.R;

public class MessengerFragment extends Fragment {

    private static final String FRAGMENT_ID = "FRAGMENT_ID";

    SharedViewModel mSharedViewModel;
    TextView mReceivedMessageView;

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

        int id = getArguments().getInt(FRAGMENT_ID);

        TextView textView = root.findViewById(R.id.label_id);
        textView.setText("Fragment id: " + String.valueOf(id));

        EditText editText = root.findViewById(R.id.message);

        Button button = root.findViewById(R.id.send_message_button);
        button.setOnClickListener(v -> mSharedViewModel.send(id, editText.getText().toString()));

        mReceivedMessageView = root.findViewById(R.id.received_message);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int id = getArguments().getInt(FRAGMENT_ID);

        mSharedViewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        mSharedViewModel.getLiveData().observe(this, message -> {
            if (message.first == id) {
                mReceivedMessageView.setText("Received message: " + message.second);
            }
        });
    }
}
