package com.star.activitytest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class SecondActivity extends BaseActivity {

    private static final String TAG = "SecondActivity";

    public static final String EXTRA_DATA = "extra_data";
    public static final String RETURNED_DATA = "returned_data";

    public static final String PARAM_1 = "param_1";
    public static final String PARAM_2 = "param_2";

    private Button mSecondButton;
    private Button mStartFirstActivity;
    private Button mStartThirdActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        Log.d(TAG, "Task id is " + getTaskId());

        setContentView(R.layout.activity_second);

        final Intent intent = getIntent();

        String data = intent.getStringExtra(EXTRA_DATA);

        if (data != null) {
            Log.d(TAG, data);
        }

        String param1 = intent.getStringExtra(PARAM_1);
        String param2 = intent.getStringExtra(PARAM_2);

        if (param1 != null && param2 != null) {
            Log.d(TAG, param1 + " " + param2);
        }

        mSecondButton = findViewById(R.id.second_button);
        mSecondButton.setOnClickListener(v -> {

            String returnedData = "Hello, FirstActivity";

            Intent intent1 = new Intent();

            intent1.putExtra(RETURNED_DATA, returnedData);

            setResult(RESULT_OK, intent1);

            finish();
        });

        mStartFirstActivity = findViewById(R.id.start_first_activity);
        mStartFirstActivity.setOnClickListener(v -> {
            Intent intent1 = new Intent(SecondActivity.this, FirstActivity.class);
            startActivity(intent1);
        });

        mStartThirdActivity = findViewById(R.id.start_third_activity);
        mStartThirdActivity.setOnClickListener(v -> {
            Intent intent1 = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent1);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(PARAM_1, data1);
        intent.putExtra(PARAM_2, data2);

        context.startActivity(intent);
    }
}
