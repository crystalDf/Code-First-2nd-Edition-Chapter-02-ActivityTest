package com.star.activitytest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class ThirdActivity extends BaseActivity {

    private static final String TAG = "ThirdActivity";

    private Button mFinishAllActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, this.toString());
        Log.d(TAG, "Task id is " + getTaskId());

        setContentView(R.layout.activity_third);

        mFinishAllActivities = findViewById(R.id.finish_all_activities);
        mFinishAllActivities.setOnClickListener(v -> ActivityCollector.finishAll());
    }
}
