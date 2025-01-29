package com.example.ex03;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String STRING_EMPTY = "";
    private static final String USER_ID = "USER_ID";

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
        actionBar.setTitle(button1.getText());

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toast.makeText(MainActivity.this,"button1 clicked",Toast.LENGTH_SHORT).show();
                button1.setEnabled(false);
                button2.setEnabled(true);
                button3.setEnabled(true);
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
                actionBar.setTitle(button3.getText());
            }
        });

        final View linearLayout1 = findViewById(R.id.linearLayout1);
        final View linearLayout2 = findViewById(R.id.linearLayout2);
        final TextView loginId = ((TextView) findViewById(R.id.login_id));
        final TextView loginPw = ((TextView) findViewById(R.id.login_pw));
        final Button loginSubmit = ((Button) findViewById(R.id.login_submit));
        final TextView loginUser = ((TextView) findViewById(R.id.login_user));
        final Button logoutSubmit = ((Button) findViewById(R.id.logout_submit));

        SharedPreferences sp = this.getPreferences(Context.MODE_PRIVATE);
        String userId = sp.getString(USER_ID, STRING_EMPTY);
        if (STRING_EMPTY.equals(userId)) {
            linearLayout1.setVisibility(View.VISIBLE);
            linearLayout2.setVisibility(View.INVISIBLE);
        } else {
            linearLayout1.setVisibility(View.INVISIBLE);
            linearLayout2.setVisibility(View.VISIBLE);
        }

        loginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = loginId.getText().toString().trim();
                String pw = loginPw.getText().toString().trim();
                if (!STRING_EMPTY.equals(id) && id.equals(pw)) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString(USER_ID, id);
                    editor.commit();
                    loginUser.setText(userId);
                    linearLayout1.setVisibility(View.INVISIBLE);
                    linearLayout2.setVisibility(View.VISIBLE);
                } else {
                    loginPw.setText(STRING_EMPTY);
                    Toast.makeText(MainActivity.this,"ログイン失敗",Toast.LENGTH_SHORT).show();
                }
            }
        });

        logoutSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sp.edit();
                editor.remove(USER_ID);
                editor.commit();
                loginId.setText(STRING_EMPTY);
                loginPw.setText(STRING_EMPTY);
                loginUser.setText(STRING_EMPTY);
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.INVISIBLE);
            }
        });

    }
}