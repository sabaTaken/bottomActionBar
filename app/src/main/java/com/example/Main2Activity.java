package com.example;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bottomappbar.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.microedition.khronos.egl.EGLDisplay;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity
{
    private FloatingActionButton fab;
    private BottomAppBar bottom_app_bar;
    private Button btnChangeFabGravityCenter ,btnChangeFabGravityEnd , btnFabRadius;
    private EditText edtFabRadius;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initialized();

        setSupportActionBar(bottom_app_bar);

        changeFabGravity();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Toast.makeText(Main2Activity.this , "fab button click" ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottomappbar_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.app_bar_fav:
                Toast.makeText(Main2Activity.this , "favorite" ,Toast.LENGTH_SHORT).show();
                return true;
            case R.id.app_bar_search:
                Toast.makeText(Main2Activity.this , "search" ,Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initialized(){
        fab = findViewById(R.id.fab);
        bottom_app_bar = findViewById(R.id.bottom_app_bar);
        btnChangeFabGravityCenter = findViewById(R.id.btnChangeFabGravityCenter);
        btnChangeFabGravityEnd = findViewById(R.id.btnChangeFabGravityEnd);
        btnFabRadius = findViewById(R.id.btnRadius);
        edtFabRadius = findViewById(R.id.edtFabRadius);
    }

    private void changeFabGravity(){
        btnChangeFabGravityCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_CENTER);
            }
        });

        btnChangeFabGravityEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                bottom_app_bar.setFabAlignmentMode(BottomAppBar.FAB_ALIGNMENT_MODE_END);
            }
        });

        btnFabRadius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if(TextUtils.isEmpty(edtFabRadius.getText().toString())){
                    bottom_app_bar.setFabCradleRoundedCornerRadius(0);
                }else{
                    bottom_app_bar.setFabCradleRoundedCornerRadius(Float.parseFloat(edtFabRadius.getText().toString()));
                }
            }
        });


    }
}
