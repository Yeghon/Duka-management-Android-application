package com.android.myduka.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.android.myduka.R;

/**
 * @author yeghon on 12/18/19
 * @project Myduka
 */
public class MySupppliersFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.suppliers, container, false);
        TextView textView=v.findViewById(R.id.text);
        textView.setText("Second Fragment");
        return v;
    }
}
