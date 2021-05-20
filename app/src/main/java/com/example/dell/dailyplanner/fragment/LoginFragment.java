package com.example.dell.dailyplanner.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.dailyplanner.R;
import com.example.dell.dailyplanner.SecondActivity;

public class LoginFragment extends Fragment {

    EditText eTName, eTStudentid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {

        View v = inflater.inflate(R.layout.activity_login_fragment, null);

        eTName = v.findViewById(R.id.Name);
        eTStudentid = v.findViewById(R.id.studentid);

        View.OnClickListener listener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = null;
                boolean error = false;

                String naame = eTName.getText().toString();
                if (naame.isEmpty()) {
                    eTName.setError("Name is missing");
                    error = true;
                } else if (naame.length() < 3) {
                    eTName.setError("Name is too short");
                    error = true;
                }

                String stdid = eTStudentid.getText().toString();
                if (stdid.isEmpty()) {
                    eTStudentid.setError("Student ID is missing");
                    error = true;
                } else if (stdid.length()<8){
                    eTStudentid.setError("Student ID is invalid");
                    error = true;
                }

                if (error) {
                    Toast.makeText(getContext(), "Data is not correct", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "You have signed in", Toast.LENGTH_LONG).show();
                   Intent i = new Intent(getActivity(), SecondActivity.class);
                    startActivity(i);
                }
            }

        };
        Button btn = (Button) v.findViewById(R.id.login);
        btn.setOnClickListener(listener);
        return v;
    }
}

