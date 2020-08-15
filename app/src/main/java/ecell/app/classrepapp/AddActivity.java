package ecell.app.classrepapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.tiper.MaterialSpinner;

import java.util.ArrayList;
import java.util.Arrays;

public class AddActivity extends AppCompatActivity {

    public ArrayList<String> branch;
    public ArrayList<String> year;
    public ArrayList<String> gender;
    public MaterialSpinner branchspinner;
    public MaterialSpinner yearspinner;
    public MaterialSpinner genderspinner;
    private TextInputLayout fullName;
    private TextInputLayout college;
    private TextInputLayout email;
    private TextInputLayout confirmEmail;
    private TextInputLayout phoneNumber;
    public Button regbutton;


    private boolean validateFullName() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(this, "Enter Name !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }


    private boolean validateBranch() {
        String val = branchspinner.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(this, "Select Branch !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            branchspinner.setError(null);
            branchspinner.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateGender() {
        String val = genderspinner.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(this, "Select Gender !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            genderspinner.setError(null);
            genderspinner.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateYear() {
        String val = yearspinner.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(this, "Select Year !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            yearspinner.setError(null);
            yearspinner.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateCollege() {
        String val = college.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(this, "Enter College !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            college.setError(null);
            college.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateConfirmEmail() {
        String val1 = confirmEmail.getEditText().getText().toString().trim();
        String val = email.getEditText().getText().toString().trim();

        if (!val1.equals(val)) {
            Toast.makeText(this, "Email Does Not Match !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+.+[a-z]+";

        if (val.isEmpty()) {
            Toast.makeText(this, "Enter Email !!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!val.matches(checkEmail)) {
            Toast.makeText(this, "Invalid Email !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(this, "Enter Valid Phone no. !!", Toast.LENGTH_SHORT).show();
            return false;
        } else if (val.contains(" ")) {
            Toast.makeText(this, "No Whitespaces in Phone no. !!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            phoneNumber.setError(null);
            phoneNumber.setErrorEnabled(false);
            return true;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        fullName = findViewById(R.id.fullname);
        college = findViewById(R.id.college);
        email = findViewById(R.id.email);
        confirmEmail = findViewById(R.id.confirmemail);
        phoneNumber = findViewById(R.id.phone);
        regbutton = findViewById(R.id.regbutton);

        // Branch Spinner
        branchspinner = findViewById(R.id.branch);
        branch = new ArrayList<String>(Arrays.asList("CSE", "EC", "EX/EE", "IT", "ME", "PCT", "AU", "CIVIL", "OTHERS"));
        ArrayAdapter<String> branchAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, branch);
        branchspinner.setAdapter(branchAdapter);
        // Branch Spinner Ends

        // Year Spinner
        yearspinner = findViewById(R.id.year);
        year = new ArrayList<String>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, year);
        yearspinner.setAdapter(yearAdapter);
        // Year Spinner Ends

        // Gender Spinner
        genderspinner = findViewById(R.id.gender);
        gender = new ArrayList<String>(Arrays.asList("MALE", "FEMALE", "PREFER NOT TO SAY"));
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, gender);
        genderspinner.setAdapter(genderAdapter);
        // Gender Spinner Ends

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}