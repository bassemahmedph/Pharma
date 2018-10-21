package com.example.islamgsayed.firstapp.adwya;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islamgsayed.firstapp.R;
import com.example.islamgsayed.firstapp.amrads_ha23a.product;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class capsules extends Fragment {

    View view;
    RecyclerView recyclerView;
    productlistAdapter productlistAdapters;
    ArrayList<product> mproducts;
    DatabaseReference databaseReference;

    public capsules() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tablets, container, false);
        recyclerView = view.findViewById(R.id.myRecycle1);
        mproducts = new ArrayList<>();
        productlistAdapters = new productlistAdapter(mproducts, getActivity());
        recyclerView.setAdapter(productlistAdapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        databaseReference = FirebaseDatabase.getInstance().getReference().child("medicine ");

        databaseReference.child("capsules").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot drags : dataSnapshot.getChildren()) {
                    product products = drags.getValue(product.class);
                    System.out.println(products.getName());
                    mproducts.add(products);


                }
                productlistAdapters.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }
}
