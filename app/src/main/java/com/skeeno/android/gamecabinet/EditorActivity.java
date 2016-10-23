package com.skeeno.android.gamecabinet;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.skeeno.android.gamecabinet.Fragment.EditorFragment;

public class EditorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        final FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment editorFragment = fragmentManager.findFragmentById(R.id.activity_editor_container);

        if(editorFragment == null) {
            editorFragment = new EditorFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.activity_editor_container, editorFragment)
                    .commit();
        }
    }
}
