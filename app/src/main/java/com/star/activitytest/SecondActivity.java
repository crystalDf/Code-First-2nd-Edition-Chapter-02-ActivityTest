package com.star.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_DATA = "extra_data";
    public static final String RETURNED_DATA = "returned_data";

    private Button mSecondButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final Intent intent = getIntent();

        String data = intent.getStringExtra(EXTRA_DATA);

        Log.d("SecondActivity", data);

        mSecondButton = (Button) findViewById(R.id.second_button);
        mSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String returnedData = "Hello, FirstActivity";

                Intent intent1 = new Intent();

                intent1.putExtra(RETURNED_DATA, returnedData);

                setResult(RESULT_OK, intent1);

                finish();
            }
        });
    }
}
