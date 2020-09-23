package com.android.myduka.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myduka.R;
import com.android.myduka.activity.MainActivity;
import com.android.myduka.adapter.MyDukaAdapter;
import com.android.myduka.model.MyDukaProducts;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * @author yeghon on 12/18/19
 * @project Myduka
 */
public class MyDukaMainFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.myduka_rec, container, false);
//        TextView textView = v.findViewById(R.id.text);
//        textView.setText("First Fragment");
//        final Context context = v.getRootView().getContext();
//        return v;

        RecyclerView rv = v.findViewById(R.id.recycler_view);

        FloatingActionButton fb = v.findViewById(R.id.productAddNewProduct);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getRootView().getContext(), "Wanna add a new product?", Toast.LENGTH_SHORT).show();
            }
        });

        MyDukaProducts sugar = new MyDukaProducts("Sugar", "Ksh. 112 / Kg", "34%");
        MyDukaProducts salt = new MyDukaProducts("Salt", "Ksh. 30 / Kg", "65%");
        MyDukaProducts oil = new MyDukaProducts("Oil", "Ksh. 156 / ltr", "87%");
        MyDukaProducts teaLeaves = new MyDukaProducts("Tea Leaves", "Ksh. 200 / Kg", "34.4%");
        MyDukaProducts flour = new MyDukaProducts("Flour", "Ksh. 126 / Kg", "12.5%");
        MyDukaProducts soap = new MyDukaProducts("Soap", "Ksh. 150 / Kg", "98%");

        ArrayList<MyDukaProducts> myDukaProductsList = new ArrayList<>();
//        Collections.emptyList();
//        List<>();
        myDukaProductsList.add(sugar);
        myDukaProductsList.add(salt);
        myDukaProductsList.add(oil);
        myDukaProductsList.add(teaLeaves);
        myDukaProductsList.add(flour);
        myDukaProductsList.add(soap);

        MyDukaAdapter ca = new MyDukaAdapter(myDukaProductsList);
        rv.setAdapter(ca);

        LinearLayoutManager llm = new LinearLayoutManager(v.getRootView().getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        return v;
    }
}
