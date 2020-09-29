package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class agregar_tarea extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tarea);
        setTitle("Agregar Nueva Tarea");
        Button button = findViewById(R.id.buttonAgregarTarea);
        Intent intent = getIntent();
        ArrayList <String> listaTareasRegistrada = intent.getStringArrayListExtra("conchetumare");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textViewCampo);
                String textoDelCampo = textView.getText().toString();
                if (textoDelCampo.isEmpty()){
                    Toast.makeText(agregar_tarea.this,"Ingrese una tarea nueva",Toast.LENGTH_SHORT).show();
                }
                for (int i, i<.lenght){

                }
            }
        });
    }
}