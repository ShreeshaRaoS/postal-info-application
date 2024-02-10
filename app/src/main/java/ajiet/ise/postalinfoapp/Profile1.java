package ajiet.ise.postalinfoapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Profile1 extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseUser user;
    private TextView textViewName;
    private TextView textViewEmail;
    private TextView textViewPhone;
    private Button buttonLogout;
    private ImageView editName;
    private ImageView editPhone;
    private ImageView editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile1);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if (user == null) {
            Intent intent = new Intent(this, login.class);
            startActivity(intent);
            finish();
        } else {
            textViewName = findViewById(R.id.user_name);
            textViewEmail = findViewById(R.id.user_details);
            textViewPhone = findViewById(R.id.user_phone);
            buttonLogout = findViewById(R.id.logout);
            editName = findViewById(R.id.editName);
            editPhone = findViewById(R.id.editPhone);
            editEmail = findViewById(R.id.editEmail);

            String userID = user.getUid();
            FirebaseFirestore.getInstance().collection("users").document(userID)
                    .get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();
                            if (document != null && document.exists()) {
                                String name = document.getString("mName");
                                String email = document.getString("email");
                                String phone = document.getString("mPhno");

                                textViewName.setText(name);
                                textViewEmail.setText(email);
                                textViewPhone.setText(phone);
                            }
                        }
                    });
        }

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(Profile1.this, login.class);
                startActivity(intent);
                finish();
            }
        });
        editName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog("Edit Name", textViewName.getText().toString(), "mName");
            }
        });

        editPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog("Edit Phone", textViewPhone.getText().toString(), "mPhno");
            }
        });

        editEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showEditDialog("Edit Email", textViewEmail.getText().toString(), "email");
            }
        });
    }

    private void showEditDialog(String title, String value, String fieldKey) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        final EditText input = new EditText(this);
        input.setText(value);
        builder.setView(input);

        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newValue = input.getText().toString();
                updateFieldInFirestore(fieldKey, newValue);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void updateFieldInFirestore(String fieldKey, String newValue) {
        String userID = user.getUid();
        FirebaseFirestore.getInstance().collection("users").document(userID)
                .update(fieldKey, newValue)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        // Field updated successfully
                        // Update the corresponding TextView with the new value
                        if (fieldKey.equals("mName")) {
                            textViewName.setText(newValue);
                        } else if (fieldKey.equals("email")) {
                            textViewEmail.setText(newValue);
                        } else if (fieldKey.equals("mPhno")) {
                            textViewPhone.setText(newValue);
                        }
                        Toast.makeText(Profile1.this, "Field updated successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        // Failed to update field
                        Toast.makeText(Profile1.this, "Failed to update field", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
