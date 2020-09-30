package ecell.app.classrepapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogincrActivity extends AppCompatActivity {

    private TextInputLayout username, password;
    private Button loginButton;
    private FirebaseAuth mAuth;
    public ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logincr);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        loginButton = findViewById(R.id.loginButton);
        mAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = username.getEditText().getText().toString().trim();
                String passwd = password.getEditText().getText().toString().trim();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(passwd))
                {
                    Toast.makeText(LogincrActivity.this, "Kindly, Fill in details correctly", Toast.LENGTH_SHORT).show();
                }
                else {

                    LoginUser(email, passwd);
                    dialog = ProgressDialog.show(LogincrActivity.this, "",
                            "E-CELL RGPV says\nLoading. Please wait...", true);
                }
            }
        });
    }

    private void LoginUser(String email, String passwd) {
        mAuth.signInWithEmailAndPassword(email, passwd)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent = new Intent(LogincrActivity.this, MainActivity.class);
//                            intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                            // Code for Login 
                            dialog.dismiss();
                            startActivity(intent);
                            finish();
                            Toast.makeText(LogincrActivity.this, "Authentication Success.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(LogincrActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
