package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mSearchWord;
    private Button mSearchButton;
    private WebView mSearchResult;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchWord = (TextView) findViewById(R.id.searchWord);
        mSearchResult = (WebView) findViewById(R.id.searchResult);
        mSearchButton = (Button) findViewById(R.id.searchButton);

        mSearchResult.getSettings().setJavaScriptEnabled(true);

        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "https://www.google.co.jp/";
                String word = mSearchWord.getText().toString();
                if (! word.isEmpty())
                    uri += "/search?q=" + word;
                mSearchResult.loadUrl(uri);
            }
        });

        if (savedInstanceState == null) {
            mSearchButton.callOnClick();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        mSearchResult.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState) {
        super.onRestoreInstanceState(inState);
        mSearchResult.restoreState(inState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStart() {
        super.onStart();
    }
    @Override
    protected void onStop() {
        super.onStop();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}