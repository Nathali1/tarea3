package com.example.nathali.tareawebview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RadioGroup rdg;
    private RadioButton rbtSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final Context context = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdg = (RadioGroup)findViewById(R.id.rdg);

        GridView gridView = (GridView) findViewById(R.id.gridView);

        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(getApplicationContext(),WebViewActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });

    }

    public void activa(View v){
        rbtSelected = (RadioButton)findViewById(rdg.getCheckedRadioButtonId());
        Toast.makeText(getApplicationContext(), rbtSelected.getText(),Toast.LENGTH_SHORT).show();
    }
}
