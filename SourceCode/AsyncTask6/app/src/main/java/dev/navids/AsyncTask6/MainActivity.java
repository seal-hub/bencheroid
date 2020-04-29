package dev.navids.AsyncTask6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {
    Object A;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MyAsyncTask().execute();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                new MyAsyncTask().execute();
            }
        });
    }


    class MyAsyncTask extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            Object ret = new Object();
            try {
                Thread.sleep(new Random().nextInt(3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return ret;
        }

        @Override
        protected void onPostExecute(Object o) {
            A = o;
        }
    }
}
