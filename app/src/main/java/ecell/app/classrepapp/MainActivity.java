package ecell.app.classrepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    public TextView nameText;
    public FirebaseUser user;

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
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(MainActivity.this, "Logout Success", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, LrActivity.class));
        finish();
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
        nameText = (TextView) findViewById(R.id.nameText);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null)
        {
            String email = user.getEmail();
            String name = email.substring(0,email.indexOf("@"));
            nameText.setText("Hello, "+ name);
        }
    }
}