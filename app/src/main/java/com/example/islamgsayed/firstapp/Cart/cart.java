package com.example.islamgsayed.firstapp.Cart;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;

import com.example.islamgsayed.firstapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class cart extends AppCompatActivity {
    RecyclerView recyclerView;
    Button checkoutBtn;
    String mAddress = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        checkoutBtn = findViewById(R.id.checkoutBtn);
        recyclerView = findViewById(R.id.cart_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CartAdapter adapter = new CartAdapter(StaticConfig.cart, this);
        recyclerView.setAdapter(adapter);

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(cart.this)
                        .setView(R.layout.address_layout)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mAddress = ((EditText) ((AlertDialog) dialog).findViewById(R.id.address)).getText().toString();

                                send();
                            }
                        }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
            }
        });


    }

    private void send() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("orders");
        Map<String, Object> data = new HashMap<>();
        data.put("userId", FirebaseAuth.getInstance().getCurrentUser().getUid());
        data.put("items", StaticConfig.cart);
        data.put("address", mAddress);

        reference.push().setValue(data);
        StaticConfig.cart.clear();
        finish();
    }

}
