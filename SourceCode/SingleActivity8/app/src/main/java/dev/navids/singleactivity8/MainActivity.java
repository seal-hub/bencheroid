package dev.navids.singleactivity8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Object A = new Object();
    Object B = new Object();
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag)
                    B = new Object();
            }
        });
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                A = new Object();
            }
        });
        new MyAsyncTask().execute();

    }

    class MyAsyncTask extends AsyncTask{
        @Override
        protected void onPostExecute(Object o) {
            B = new Object();
            flag = true;
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            A = new Object();
            return null;
        }
    }

}
