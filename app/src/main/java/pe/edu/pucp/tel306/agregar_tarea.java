package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.pucp.tel306.Entity.Usuario;

public class agregar_tarea extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tarea);
        setTitle("Agregar Nueva Tarea");

        Intent intent = getIntent();
        final Usuario usuario = (Usuario) intent.getSerializableExtra("usu2");
        ArrayList<String> listaTareasRegistrada = usuario.getListaTarea();

        TextView textView = findViewById(R.id.textViewCampo);
        String textoDelCampo = textView.getText().toString();

       /* switch (usuario.getEspecialidad()) {
            case "electronica":
                agregar_tarea.this.setTheme(R.style.mdcThemeElectro);
                break;
            case "telecomunicaciones":
                agregar_tarea.this.setTheme(R.style.mdcThemeTelecom);
            case "informatica":
                agregar_tarea.this.setTheme(R.style.mdcThemeInf);
            default:
                agregar_tarea.this.setTheme(R.style.porDefecto);
        } */

        if (textoDelCampo.isEmpty()) {
            Toast.makeText(agregar_tarea.this, "Error, tarea nueva vacía.", Toast.LENGTH_SHORT).show();
        } else {
            for (String comprobar : listaTareasRegistrada) {
                if (comprobar.equalsIgnoreCase(textoDelCampo)) {
                    Toast.makeText(agregar_tarea.this, "Tarea ya registrada, ingrese una tarea nueva.", Toast.LENGTH_SHORT).show();
                } else {
                    listaTareasRegistrada.add(textoDelCampo);
                    usuario.setListaTarea(listaTareasRegistrada);
                    Button button = findViewById(R.id.buttonAgregarTarea);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent1 = new Intent(agregar_tarea.this, tareas_pendientes.class);
                            intent1.putExtra("usu2", usuario);
                            setResult(RESULT_OK, intent1);
                            finish();
                        }
                    });
                }
            }
        }
    }
}