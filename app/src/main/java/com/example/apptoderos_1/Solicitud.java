package com.example.apptoderos_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class Solicitud extends AppCompatActivity {

    private String informacion= "";
    private TextInputEditText tie_informacion;
    private MaterialButton b_confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solicitud);

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null){
            informacion=bundle.getString("descripcion");
        }

        tie_informacion=findViewById(R.id.tie_descripcion);
        b_confirmar=findViewById(R.id.b_confirmar);


        tie_informacion.setText(informacion);

        b_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               informacion=tie_informacion.getText().toString();

               Intent intent= new Intent(Solicitud.this, MainActivity.class);
               intent.putExtra("informacion", informacion);
               startActivity(intent);
            }

        });
    }
}