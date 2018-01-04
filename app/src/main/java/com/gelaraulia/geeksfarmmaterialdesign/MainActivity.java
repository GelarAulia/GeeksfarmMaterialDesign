package com.gelaraulia.geeksfarmmaterialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_toCardView = (Button)findViewById(R.id.btn_toCardView);
        Button btn_toRecyclerView = (Button)findViewById(R.id.btn_toRecyclerView);
        btn_toCardView.setOnClickListener(this);
        btn_toRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_toCardView:
                intent = new Intent(MainActivity.this,CardViewActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_toRecyclerView:
                intent = new Intent(MainActivity.this,RecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
