package dev.navids.lifecycle3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity{

    Object onCreate_onClick = new Object();
    Object onResume_onScrollChange = new Object();
    Object onClick_onStop = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreate_onClick = null;
                onClick_onStop = null;
            }
        });
        findViewById(R.id.scrollview).setOnScrollChangeListener(new View.OnScrollChangeListener(){

            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                onResume_onScrollChange = null;
            }
        });
        onCreate_onClick.toString();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResume_onScrollChange.toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        onClick_onStop.toString();
    }
}
