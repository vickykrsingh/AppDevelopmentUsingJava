package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import  android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Get references to EditText and Button
        EditText emailEditText = findViewById(R.id.email);
        EditText passwordEditText = findViewById(R.id.password);
        Button submitButton = findViewById(R.id.button);
        TextView resultTextView = findViewById(R.id.result);

        // Set an OnClickListener on the button
        submitButton.setOnClickListener(v -> {
            // Get text from EditText fields
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Create a string to append
            String result = "Email: " + email + "\nPassword: " + password + "\n";

            // Append the result to the TextView
            resultTextView.append(result);

            // Optional: Log the data
            Log.d(TAG, "Email: " + email);
            Log.d(TAG, "Password: " + password);
        });

        // Handle system window insets for padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
