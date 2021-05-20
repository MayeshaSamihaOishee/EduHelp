package com.example.dell.dailyplanner.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dell.dailyplanner.R;
import com.example.dell.dailyplanner.SecondActivity;

import java.util.HashMap;
import java.util.Map;

public class SignupFragment extends Fragment {
    EditText eTfName, eTstudentid,  eTphoneNo, eTEmail;
    Button SignupButton;
    RequestQueue requestQueue;

    String NameHolder, StudentIdHolder, PhoneHolder, EmailHolder;

    String HttpUrl = "http://hj.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {

        View v = inflater.inflate(R.layout.activity_signup_fragment, null);

        eTfName = v.findViewById(R.id.NameSignup);
        eTstudentid = v.findViewById(R.id.studentidSignup);
        eTphoneNo = v.findViewById(R.id.phonenum);
        eTEmail = v.findViewById(R.id.email);
        SignupButton = (Button) v.findViewById(R.id.StudentRegister);

        requestQueue = Volley.newRequestQueue(getContext());

        SignupButton.setOnClickListener(new View.OnClickListener()  {

                                            @Override
                                            public void onClick(View v) {

                                                Intent intent = null;
                                                boolean error = false;

                                                String name = eTfName.getText().toString();
                                                if (name.isEmpty()) {
                                                    eTfName.setError("Name is missing");
                                                    error = true;
                                                } else if (name.length() < 3) {
                                                    eTfName.setError("Name is too short");
                                                    error = true;
                                                }

                                                String stdid = eTstudentid.getText().toString();
                                                if (stdid.isEmpty()) {
                                                    eTstudentid.setError("Student ID is missing");
                                                    error = true;
                                                } else if (stdid.length()<8){
                                                    eTstudentid.setError("Student ID is invalid");
                                                    error = true;
                                                }

                                                String phoonenum = eTphoneNo.getText().toString();
                                                if (phoonenum.isEmpty()) {
                                                    eTphoneNo.setError("Mobile Number is missing");
                                                    error = true;
                                                } else if (phoonenum.length() == 11) {
                                                    if (phoonenum.startsWith("015") || phoonenum.startsWith("016") || phoonenum.startsWith("017") || phoonenum.startsWith("018") || phoonenum.startsWith("019") || phoonenum.startsWith("011")) {
                                                    } else if ((phoonenum.contains("0")) || (phoonenum.contains("1")) || (phoonenum.contains("2")) || (phoonenum.contains("3")) || (phoonenum.contains("4")) || (phoonenum.contains("5"))
                                                            || (phoonenum.contains("6")) || (phoonenum.contains("7")) || (phoonenum.contains("8")) || (phoonenum.contains("9"))) {
                                                    } else {
                                                        eTphoneNo.setError("Mobile Number is not valid");
                                                        error = true;
                                                    }
                                                } else if ((phoonenum.length() == 14)) {
                                                    if ((phoonenum.startsWith("+88015")) || (phoonenum.startsWith("+88016")) || (phoonenum.startsWith("+88017")) || (phoonenum.startsWith("+88018")) || (phoonenum.startsWith("+88019"))) {
                                                    } else if ((phoonenum.contains("0")) || (phoonenum.contains("1")) || (phoonenum.contains("2")) || (phoonenum.contains("3")) || (phoonenum.contains("4")) || (phoonenum.contains("5"))
                                                            || (phoonenum.contains("6")) || (phoonenum.contains("7")) || (phoonenum.contains("8")) || (phoonenum.contains("9"))) {
                                                    } else {
                                                        eTphoneNo.setError("Mobile Number is not valid");
                                                        error = true;
                                                    }
                                                } else {
                                                    eTphoneNo.setError("Mobile Number is not valid");
                                                    error = true;
                                                }
                                                String eemail = eTEmail.getText().toString();
                                                if (eemail.isEmpty()) {
                                                    eTEmail.setError("Email id is missing");
                                                    error = true;
                                                } else if (eemail.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                                                } else {
                                                    eTEmail.setError("Email id is invalid");
                                                    error = true;
                                                }

                                                if (error == true) {
                                                    Toast.makeText(getContext(), "Data is not correct", Toast.LENGTH_LONG).show();
                                                } else {
                                                    GetValueFromEditText();
                                                    StringRequest stringRequest = new StringRequest(Request.Method.POST, HttpUrl,
                                                            new Response.Listener<String>() {
                                                                @Override
                                                                public void onResponse(String ServerResponse) {
                                                                    Toast.makeText(getContext(), "Registration is complete", Toast.LENGTH_LONG).show();
                                                                }
                                                            },
                                                            new Response.ErrorListener() {
                                                                @Override
                                                                public void onErrorResponse(VolleyError volleyError) {
                                                                    Toast.makeText(getContext(), "Data is not inserted", Toast.LENGTH_LONG).show();
                                                                }
                                                            }) {
                                                        @Override
                                                        protected Map<String, String> getParams() {

                                                            // Creating Map String Params.
                                                            Map<String, String> params = new HashMap<String, String>();

                                                            // Adding All values to Params.
                                                            params.put("Name", NameHolder);
                                                            params.put("StudentID", StudentIdHolder);
                                                            params.put("MobileNo", PhoneHolder);
                                                            params.put("Email", EmailHolder);
                                                            return params;
                                                        }

                                                    };
                                                    // Creating RequestQueue.
                                                    RequestQueue requestQueue = Volley.newRequestQueue(getContext());
                                                    // Adding the StringRequest object into requestQueue.
                                                    requestQueue.add(stringRequest);

                                                    Intent i = new Intent(getActivity(), SecondActivity.class);
                                                    startActivity(i);
                                                }
                                            }
                                        }
        );
        Button btn =(Button) v.findViewById(R.id.StudentRegister);
        return v;
    }

    private void GetValueFromEditText() {
        NameHolder = eTfName.getText().toString().trim();
        StudentIdHolder = eTstudentid.getText().toString().trim();
        PhoneHolder = eTphoneNo.getText().toString().trim();
        EmailHolder = eTEmail.getText().toString().trim();
    }

}
