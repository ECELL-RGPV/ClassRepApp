package ecell.app.classrepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LrActivity extends AppCompatActivity {

    public void loginRedirect(View view)
    {
        startActivity(new Intent(LrActivity.this, LoginActivity.class));
    }

    public void regRedirect(View view)
    {
        startActivity(new Intent(LrActivity.this, RegistrationActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr);
    }
}