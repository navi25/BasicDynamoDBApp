package io.navi.aws_db;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amazonaws.mobile.client.AWSMobileClient;
import com.amazonaws.mobile.client.AWSStartupHandler;
import com.amazonaws.mobile.client.AWSStartupResult;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final String FORM_DATA = "io.navi.basic.FORM_DATA";
    HashMap<String,String> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AWSMobileClient.getInstance().initialize(this, new AWSStartupHandler() {
            @Override
            public void onComplete(AWSStartupResult awsStartupResult) {
                Log.d("MainActivity", "AWSMobileClient is instantiated and you are connected to AWS!");
            }
        }).execute();
    }




    public void OnFormSubmit(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText name = findViewById(R.id.name);
        String name_val = name.getText().toString();
        map.put("name",name_val);

        EditText location = findViewById(R.id.location);
        String loc_val = location.getText().toString();
        map.put("location",loc_val);

        EditText pass = findViewById(R.id.password);
        String pass_val = pass.getText().toString();
        map.put("password",pass_val);

        intent.putExtra(FORM_DATA, map);
        startActivity(intent);

    }

    public void ShowList(View v){
        Intent intent = new Intent(this, ShowListActivity.class);
    }
}
