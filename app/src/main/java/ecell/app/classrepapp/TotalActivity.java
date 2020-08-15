package ecell.app.classrepapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TotalActivity extends AppCompatActivity {

    public ArrayList<String> regList;
    public ListView regListView;
    public ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        regList = new ArrayList<String>();
        regListView  = findViewById(R.id.regList);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, regList){

            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view =  super.getView(position, convertView, parent);
                TextView ListItemShow = (TextView) view.findViewById(android.R.id.text1);
                ListItemShow.setTextColor(Color.parseColor("#fe00fb"));
                return view;
            }
        };
        regListView.setAdapter(arrayAdapter);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        if(user != null)
        {
            String email = user.getEmail();
            final String crname = email.substring(0,email.indexOf("@"));
            DatabaseReference myref = database.getReference().child("Total").child(crname);

            myref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot)
                {
                    regList.clear();
                    for(DataSnapshot snap : snapshot.getChildren())
                    {
                        String ans = "";
                        for(DataSnapshot subsnap : snap.getChildren())
                        {
                            String n;
                            String e;
                            String p;

                            if(subsnap.getKey().equals("Name") || subsnap.getKey().equals("Email") || subsnap.getKey().equals("Phone"))
                            {
                                ans = ans + (subsnap.getKey().toString() + " - " +  subsnap.getValue().toString() + "\n");
                            }
                        }
                        regList.add(ans);
                    }
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error){}
            });
        }
    }
}