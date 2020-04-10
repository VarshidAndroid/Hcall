package com.example.hcall.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.hcall.Help;
import com.example.hcall.MainActivity;
import com.example.hcall.R;
import com.example.hcall.SharedPrefsUtils;

public class CampaignFragment extends Fragment {
    ConstraintLayout arrow1, arrow2, arrow3;

    public CampaignFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_campagin, container, false);


        arrow1 = (ConstraintLayout) view.findViewById(R.id.arrow_1);
        arrow2 = (ConstraintLayout) view.findViewById(R.id.arrow_2);
        arrow3 = (ConstraintLayout) view.findViewById(R.id.arrow_3);


        arrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CampaignListFragment());

            }
        });
        arrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CampaignListFragment());
            }
        });
        arrow3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new CampaignListFragment());
            }
        });



          return view;



    }







    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.host_main, fragment);
        fragmentTransaction.commit(); // save the changes

    }
}




