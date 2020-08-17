package ecell.app.classrepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class LrActivity extends AppCompatActivity {

    public void loginRedirect(View view)
    {
        startActivity(new Intent(LrActivity.this, LogincrActivity.class));
        finish();
    }

    public void regRedirect(View view)
    {
        startActivity(new Intent(LrActivity.this, RegistrationActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lr);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}