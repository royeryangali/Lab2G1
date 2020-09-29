package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pe.edu.pucp.tel306.Entity.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mandarParametros(View view){
        TextView textViewNombre = findViewById(R.id.nomcam);
        String nomcam = textViewNombre.getText().toString();

        TextView textViewApellido = findViewById(R.id.apecam);
        String apecam = textViewApellido.getText().toString();

        TextView textViewEspecialidad = findViewById(R.id.espcam);
        String espcam = textViewEspecialidad.getText().toString();

        TextView textViewDNI = findViewById(R.id.dnicam);
        String dnicam = textViewDNI.getText().toString();

        TextView textViewCam = findViewById(R.id.clavecam);
        String clavecam = textViewCam.getText().toString();

        Usuario usu = new Usuario();


    }


}