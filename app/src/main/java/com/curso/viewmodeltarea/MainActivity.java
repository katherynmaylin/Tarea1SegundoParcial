package com.curso.viewmodeltarea;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.curso.viewmodeltarea.ui.main.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_view_tag, MainFragment.newInstance())
                    .commitNow();
        }
    }
}