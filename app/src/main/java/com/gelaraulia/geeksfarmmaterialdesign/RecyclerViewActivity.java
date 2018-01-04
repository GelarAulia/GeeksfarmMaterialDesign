package com.gelaraulia.geeksfarmmaterialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewActivity extends AppCompatActivity {
    String[] products = new String[]{"Windows","OSX","Ubuntu"};
    RecyclerView rv_products;
    RecyclerView.Adapter rv_adapter;
    RecyclerView.LayoutManager rv_layout_manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        Log.e("ACTIVITY","CreateRV");
        rv_products = (RecyclerView)findViewById(R.id.rv_products);
        rv_products.setHasFixedSize(true);

        Log.e("ACTIVITY","CreateLM");
        rv_layout_manager = new LinearLayoutManager(this);
        rv_products.setLayoutManager(rv_layout_manager);

        Log.e("ACTIVITY","STARTRV");
        rv_adapter = new MyAdapter(products);

        Log.e("ACTIVITY","SetAdapter");
        rv_products.setAdapter(rv_adapter);
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] ds_products;
        public class ViewHolder extends RecyclerView.ViewHolder {
            public CardView cv_products;
            public TextView tv_product;
            public ViewHolder(View itemView) {
                super(itemView);
                Log.e("ADAPTER","VHClass");
                cv_products = (CardView)itemView.findViewById(R.id.cv_products);
                tv_product = (TextView)itemView.findViewById(R.id.tv_product);
            }
        }
        public MyAdapter(String[] dataset) {
            Log.e("ADAPTER","GET DATA");
            ds_products = dataset;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Log.e("ADAPTER","ONCREATEVIEWHOLDER");
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_product, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        public void onBindViewHolder(ViewHolder holder, int position) {
            Log.e("ADAPTER","ONBINDVH");
            holder.tv_product.setText(ds_products[position]);
        }

        @Override
        public int getItemCount() {
            return ds_products.length;
        }
    }
}
