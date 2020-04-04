package dev.navids.multicomp1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Object A = new Object();
    Object B = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.second_act_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.dialog_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("A dialog")
                        .setMessage("Are you sure?")
                        .setPositiveButton(android.R.string.yes, null)
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("---- onStart");
        A = new Object();
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("---- onResume");
        A.toString();
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("---- onPause");
        A = null;
    }


}
