package dev.navids.singleactivity1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Object memoryObject = new Object();
    Object secondMemoryObject = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickUse(view);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickFree(view);
            }
        });
    }

    public void onClickUse(View view){
        memoryObject.toString();
    }

    public void onClickFree(View view){
        memoryObject = null;
        secondMemoryObject.toString();
    }

    public void wihtoutListener(){
        secondMemoryObject = null;
    }
}
