package com.example.hcall.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.hcall.Lead1;
import com.example.hcall.R;
import com.example.hcall.SharedPrefsUtils;

import java.util.ArrayList;
import java.util.List;

public class CampaignListFragment extends Fragment {
    ConstraintLayout A;
    Spinner spinner;
    String[] SPINNERVALUES = {"Dial List","Lead1","Lead2","Lead3","Lead4","Lead5","Lead6","Lead7","Lead8"};
    String SpinnerValue;



    public CampaignListFragment() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view =inflater.inflate(R.layout.fragment_campaign_list, container, false);
        SharedPrefsUtils.setSharedPreferenceString(getContext(),"back","0.0");



        spinner =(Spinner)view.findViewById(R.id.spinner);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, SPINNERVALUES);

        spinner.setAdapter(adapter);

        //Adding setOnItemSelectedListener method on spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                SpinnerValue = (String) spinner.getSelectedItem();
                switch (SpinnerValue) {
                    case "Dial List":

                        break;

                    case "Lead1":
                        Intent intent = new Intent(getActivity(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead2":
                        intent = new Intent(getActivity(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead3":
                        intent = new Intent(getContext(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead4":
                        intent = new Intent(getContext(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead5":
                        intent = new Intent(getContext(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead6":
                        intent = new Intent(getContext(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead7":
                        intent = new Intent(getContext(), Lead1.class);
                        startActivity(intent);
                        break;

                    case "Lead8":
                        intent = new Intent(getContext(), Lead1.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });







        return view;
    }



}