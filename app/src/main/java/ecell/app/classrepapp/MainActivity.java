package ecell.app.classrepapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    public TextView nameText;
    public FirebaseUser user;
    public TextView regcount;
    public FirebaseDatabase database;

    public void addreg(View view) {
        startActivity(new Intent(MainActivity.this, AddActivity.class));
    }

    public void compreg(View view) {
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
        regcount = (TextView) findViewById(R.id.regCount);
        database = FirebaseDatabase.getInstance();

        user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String email = user.getEmail();
            String name = email.substring(0, email.indexOf("@"));
            nameText.setText("Hello, " + name + "\nYOUR DASHBOARD");
            DatabaseReference myref = database.getReference().child("Total").child(name);

            myref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    regcount.setText("TOTAL REGs\n" + snapshot.getChildrenCount());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        }
    }
}