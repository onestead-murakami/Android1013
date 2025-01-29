package com.example.ex02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        final ActionBar actionBar = getSupportActionBar();
        final Button button1 = ((Button) findViewById(R.id.button1));
        final Button button2 = ((Button) findViewById(R.id.button2));
        final Button button3 = ((Button) findViewById(R.id.button3));
        final TextView textView1 = ((TextView) findViewById(R.id.textView1));
        textView1.setText(button1.getText());
        actionBar.setTitle(button1.getText());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button1 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
                textView1.setText(button1.getText());
                actionBar.setTitle(button1.getText());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button2 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(true);
                button2.setEnabled(false);
                button3.setEnabled(true);
                textView1.setText(button2.getText());
                actionBar.setTitle(button2.getText());
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button3 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(true);
                button2.setEnabled(true);
                button3.setEnabled(false);
                textView1.setText(button3.getText());
                actionBar.setTitle(button3.getText());
            }
        });

    }
}