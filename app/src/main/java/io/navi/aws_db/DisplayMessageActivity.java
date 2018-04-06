package io.navi.aws_db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();

        TextView tv = findViewById(R.id.textView);

        HashMap<String, String> hashMap= (HashMap<String, String>)intent.getSerializableExtra(MainActivity.FORM_DATA);

        String msg = hashMap.values().toString();

        tv.setText(msg);
    }
}
