package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lpa.carteiradigitalfaci_pt.R;


public class FragmentCertidao extends Fragment {
    View view;
    public FragmentCertidao() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_certidao, container, false);
        return view;
    }
}
