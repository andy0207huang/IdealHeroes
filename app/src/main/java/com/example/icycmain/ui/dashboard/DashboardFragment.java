package com.example.icycmain.ui.dashboard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.icycmain.MessageBoard;
import com.example.icycmain.PTHowToPlay;
import com.example.icycmain.R;
import com.example.icycmain.dmInstr;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private Button btnDM, btnMessageBoard, btnPetTrainer;

    @SuppressLint("WrongViewCast")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);




        btnDM = (Button) view.findViewById(R.id.btn_DM);
        btnDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), dmInstr.class);
                startActivity(intent);
            }
        });

      btnMessageBoard = (Button) view.findViewById(R.id.btn_MessageBoard);
        btnMessageBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                Intent intentMB = new Intent(getActivity(), MessageBoard.class);
                startActivity(intentMB);
            }
        });


        btnPetTrainer = (Button) view.findViewById(R.id.button26);
        btnPetTrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intentPT = new Intent(getActivity(), PTHowToPlay.class);
                startActivity(intentPT);
            }
        });

        return view;
    }


}