package com.star.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;

    private Button mFirstButton;
    private Button mActionView;
    private Button mActionDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        mFirstButton = (Button) findViewById(R.id.first_button);
        mFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "First Button", Toast.LENGTH_LONG).show();
//                finish();
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);

                String data = "Hello, SecondActivity";

                Intent intent = new Intent("com.star.activity.ACTION_START");
                intent.addCategory("com.star.activity.MY_CATEGORY");

                intent.putExtra(SecondActivity.EXTRA_DATA, data);

//                startActivity(intent);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        mActionView = (Button) findViewById(R.id.action_view);
        mActionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.baidu.com"));
                startActivity(intent);
            }
        });

        mActionDial = (Button) findViewById(R.id.action_dial);
        mActionDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra(SecondActivity.RETURNED_DATA);

                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_first, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "Add Item", Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "Remove Item", Toast.LENGTH_LONG).show();
                break;
            default:
        }

        return true;
    }
}
