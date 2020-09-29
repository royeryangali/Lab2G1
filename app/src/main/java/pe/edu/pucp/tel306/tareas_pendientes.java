package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import pe.edu.pucp.tel306.Entity.Usuario;

public class tareas_pendientes extends AppCompatActivity {

    ArrayList<Integer> checkedlist = new ArrayList<Integer>();

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

        if(usuario2.getListaTarea().isEmpty() || usuario2.getListaTarea() == null){
            noHayTAreas.setVisibility(View.VISIBLE);
        }else{
            noHayTAreas.setVisibility(View.GONE);
            int i = 1;
            for(String a : usuario2.getListaTarea()){
                CheckBox cb = new CheckBox(this);
                cb.setId(Integer.valueOf(i));
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