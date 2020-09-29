package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pe.edu.pucp.tel306.Entity.Usuario;

public class tareas_pendientes extends AppCompatActivity {

    ArrayList<Integer> checkedlist = new ArrayList<Integer>();
    int clickcount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tareas_pendientes);

        setTitle("PucpToDoList");

        Intent intent = getIntent();
        final Usuario usuario = (Usuario) intent.getSerializableExtra("usu");
        Usuario usuario2 = (Usuario) intent.getSerializableExtra("usu2");
        TextView textobienvenida = findViewById(R.id.textViewBienvenido);
        textobienvenida.setText("Bienvenido " + usuario.getNombre() + " " + usuario.getApellido());
        TextView noHayTAreas = findViewById(R.id.textView4);
        LinearLayout layout = findViewById(R.id.linearLayoutCheck);
        ImageButton imageButton = findViewById(R.id.imageButton2);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickcount=clickcount+1;
                if(clickcount==5) {
                    Toast.makeText(getApplicationContext(),"Has desbloqueado la opción oscura", Toast.LENGTH_LONG).show();
                    clickcount = 0;
                }
            }
        });

        if(usuario.getEspecialidad().equalsIgnoreCase("Telecomunicaciones")){
            imageButton.setImageResource(R.drawable.fibra);
        }else if(usuario.getEspecialidad().equalsIgnoreCase("Electronica")){
            imageButton.setImageResource(R.drawable.elec);
        }else if(usuario.getEspecialidad().equalsIgnoreCase("mecatronica")){
            imageButton.setImageResource(R.drawable.meca);
        }
        if(usuario2.getListaTarea().isEmpty() || usuario2.getListaTarea() == null){
            noHayTAreas.setVisibility(View.VISIBLE);
        }else{
            noHayTAreas.setVisibility(View.GONE);
            int i = 1;
            for(String a : usuario2.getListaTarea()){
                CheckBox cb = new CheckBox(this);
                cb.setId(i);
                cb.setText(a);
                cb.setOnClickListener(ckListener);
                layout.addView(cb);
                i++;
            }
        }

        Button agregarTarea = findViewById(R.id.buttonAgregarTarea);
        agregarTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tareas_pendientes.this,agregar_tarea.class);
                int request = 1;
                intent.putExtra("usu2", usuario);
                startActivityForResult(intent,request);
            }
        });

        Button volverAlFormulario = findViewById(R.id.volverFormularioButton);
        volverAlFormulario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tareas_pendientes.this,agregar_tarea.class);
                startActivity(intent);
            }
        });

    }

    private View.OnClickListener ckListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            int id = view.getId();
            boolean checked = ((CheckBox) view).isChecked();
            if(checked){
                checkedlist.add(id);
            }else{
                checkedlist.remove(new Integer(id));
            }
        }
    };



}