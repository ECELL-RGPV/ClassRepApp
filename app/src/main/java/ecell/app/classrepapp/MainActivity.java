package ecell.app.classrepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void addreg(View view)
    {
        startActivity(new Intent(MainActivity.this, AddActivity.class));
    }

    public void compreg(View view)
    {
        startActivity(new Intent(MainActivity.this, TotalActivity.class));
    }


    public void helpact(View view)
    {
        startActivity(new Intent(MainActivity.this, HelpActivity.class));
    }

    public void logout(View view)
    {
        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
    }

    public void exitfunc(View view)
    {
        Toast.makeText(this, "Exit in 3 seconds", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finishAffinity();
            }
        }, 3000);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}