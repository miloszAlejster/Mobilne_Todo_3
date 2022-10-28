package com.example.todo;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.Optional;
import java.util.UUID;

public class TaskFragment extends Fragment {
    public static final String ARG_TASK_ID = "taskId";
    private Task task;
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID taskId = (UUID) getActivity().getIntent().getSerializableExtra(ARG_TASK_ID);
        task = TaskStorage.getInstance().getTask(taskId);
    }
    public static TaskFragment newInstance(UUID taskId){
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TASK_ID, taskId);
        TaskFragment taskFragment = new TaskFragment();
        taskFragment.setArguments(bundle);
        return taskFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView nameField = getView().findViewById(R.id.task_name);
        nameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                task.setName(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Button dateButton = container.findViewById(R.id.task_date);
        if (dateButton != null) {
            dateButton.setText(task.getDate().toString());
            dateButton.setEnabled(false);
        }

        CheckBox doneCheckbox = container.findViewById(R.id.task_done);
        if (doneCheckbox != null) {
            doneCheckbox.setChecked(task.isDone());
            doneCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> task.setDone(isChecked));
        }
        return inflater.inflate(R.layout.fragment_task, container, false);
    }
}
