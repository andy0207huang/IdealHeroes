package com.example.icycmain.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.icycmain.DrawMasters;
import com.example.icycmain.HowToPlay;
import com.example.icycmain.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button btnHowToPlay;

    @SuppressLint("WrongViewCast")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

//opens how to play, back buttons still left to program**
        btnHowToPlay = (Button) view.findViewById(R.id.btn_HowtoPlay);
        btnHowToPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getActivity(), HowToPlay.class);
                startActivity(intent1);
            }
        });
        return view;
    }
}