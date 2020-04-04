package dev.navids.executor2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
    Object A = new Object();
    Object B = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("--------- " + A.toString());
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                A = null;
                B = null;
                System.out.println("--------- NULL");
            }
        });
        executorService.submit(new Runnable() {
            @Override
            public void run() {

                try {
                    System.out.println("--------- " + B.toString());
                }
                catch (Exception e) {
                    System.out.println("---- An exception happened!");
                    throw new RuntimeException("------- An exception");
                }
            }
        });
    }
}
