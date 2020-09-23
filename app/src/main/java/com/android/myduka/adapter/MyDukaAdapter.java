package com.android.myduka.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.myduka.model.MyDukaProducts;
import com.android.myduka.R;

import java.util.ArrayList;

/**
 * @author yeghon on 12/10/19
 * @project Myduka
 */
public class MyDukaAdapter extends
        RecyclerView.Adapter<MyDukaAdapter.MyViewHolder> {

    private ArrayList<MyDukaProducts> myDukaProducts;

    /**
     * View holder class
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        public CircleImageView productImage;
        public TextView productName, productPrice, productStockRemaining;
        public RelativeLayout productLayout;

        public MyViewHolder(View view) {
            super(view);
//            productImage = view.findViewById(R.id.productImage);
            productName = view.findViewById(R.id.productName);
            productPrice = view.findViewById(R.id.productPrice);
            productStockRemaining = view.findViewById(R.id.productStockRemaining);
            productLayout = view.findViewById(R.id.productRelative);
        }
    }

    public MyDukaAdapter(ArrayList<MyDukaProducts> myDukaProducts) {
        this.myDukaProducts = myDukaProducts;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        MyDukaProducts c = myDukaProducts.get(position);
//        holder.productName.setText(c);
        holder.productName.setText(c.productName);
        holder.productPrice.setText(c.productPrice);
        holder.productStockRemaining.setText(c.productStock);
        holder.productLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getRootView().getContext(), "You clicked on " + myDukaProducts.get(position).productName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return myDukaProducts.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new MyViewHolder(v);
    }
}