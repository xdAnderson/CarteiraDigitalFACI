package com.example.lpa.carteiradigitalfaci_pt.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lpa.carteiradigitalfaci_pt.R;


public class FragmentMenuPrincipal extends Fragment {
    View view;
    public FragmentMenuPrincipal() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_menu_principal, container, false);
        return view;
    }
}
