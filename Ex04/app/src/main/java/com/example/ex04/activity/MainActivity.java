package com.example.ex04.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ex04.R;
import com.example.ex04.fragment.DashBoardFragment;
import com.example.ex04.fragment.LoginFragment;
import com.example.ex04.fragment.NotificationsFragment;

public class MainActivity extends AppCompatActivity {

    public static final String STRING_EMPTY = "";
    public static final String USER_ID = "USER_ID";
    public void replaceFragment(@IdRes int containerViewId, @NonNull Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(containerViewId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void putString(String key, String value) {
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void removeString(String key) {
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    public String getString(String key) {
        SharedPreferences sp = getPreferences(Context.MODE_PRIVATE);
        return sp.getString(key, STRING_EMPTY);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState == null) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.add(R.id.fragment_activity_main, LoginFragment.newInstance("", ""));
            transaction.commit();
        }

        final ActionBar actionBar = getSupportActionBar();
        final Button button1 = ((Button) findViewById(R.id.button1));
        final Button button2 = ((Button) findViewById(R.id.button2));
        final Button button3 = ((Button) findViewById(R.id.button3));
        actionBar.setTitle(button1.getText());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button1 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                actionBar.setTitle(button1.getText());
                replaceFragment(R.id.fragment_activity_main, LoginFragment.newInstance("", ""));
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button2 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(true);
                button2.setEnabled(false);
                button3.setEnabled(true);
                actionBar.setTitle(button2.getText());
                replaceFragment(R.id.fragment_activity_main, DashBoardFragment.newInstance("", ""));
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button3 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(false);
                actionBar.setTitle(button3.getText());
                replaceFragment(R.id.fragment_activity_main, NotificationsFragment.newInstance("", ""));
            }
        });

    }
}