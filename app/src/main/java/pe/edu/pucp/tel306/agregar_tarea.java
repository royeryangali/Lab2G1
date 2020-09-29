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
        final ArrayList<String> listaTareasRegistrada = intent.getStringArrayListExtra("listaTareas");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textViewCampo);
                String textoDelCampo = textView.getText().toString();
                Boolean flag = true;
                if (textoDelCampo.isEmpty()) {
                    Toast.makeText(agregar_tarea.this, "Ingrese una tarea nueva.", Toast.LENGTH_SHORT).show();
                } else {
                    for (String comprobar : listaTareasRegistrada) {
                        if (comprobar.equalsIgnoreCase(textoDelCampo)){
                            Toast.makeText(agregar_tarea.this, "Tarea ya registrada, ingrese una tarea nueva.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}