package com.example.apptoderos_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Servicios extends AppCompatActivity {

    private String plomeria= "plomeria";
    private String electricidad= "electricidad";
    private String carpinteria= "carpinteria";
    private TextInputEditText tie_plomeria, tie_electricidad, tie_carpinteria;
    private MaterialButton b_solicitar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicios);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            plomeria = bundle.getString("plomeria");
            electricidad = bundle.getString("electricidad");
            carpinteria = bundle.getString("carpinteria");
        }

        tie_plomeria=findViewById(R.id.tie_plomeria);
        tie_electricidad=findViewById(R.id.tie_electricidad);
        tie_carpinteria=findViewById(R.id.tie_carpinteria);
        b_solicitar=findViewById(R.id.b_solicitar);

        tie_plomeria.setText(plomeria);
        tie_electricidad.setText(electricidad);
        tie_carpinteria.setText(carpinteria);

        b_solicitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                plomeria= tie_plomeria.getText().toString();
                electricidad= tie_electricidad.getText().toString();
                carpinteria= tie_carpinteria.getText().toString();

                Intent intent=new Intent(Servicios.this, Solicitud.class);
                intent.putExtra("plomeria", plomeria);
                intent.putExtra("electricidad",electricidad);
                intent.putExtra("carpinteria", carpinteria);
                startActivity(intent);


            }
        });


    }
}