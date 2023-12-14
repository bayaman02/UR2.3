package com.classwork.ur23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private Button minusl;
    private Button pius;
    private Button next;
    private TextView textView;
    private int conteinet = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        minusl = requireActivity().findViewById(R.id.btn2);
        pius = requireActivity().findViewById(R.id.btn1);
        next = requireActivity().findViewById(R.id.btn3);
        textView = requireActivity().findViewById(R.id.text_view);

        minusl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conteinet = conteinet - 1;
                textView.setText(String.valueOf(conteinet));
            }
        });

        pius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conteinet = conteinet + 1;
                textView.setText(String.valueOf(conteinet));
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondFragment secondFragment = new SecondFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key", String.valueOf(conteinet));
                secondFragment.setArguments(bundle);
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).commit();
            }
        });
    }
}