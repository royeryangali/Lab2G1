package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.pucp.tel306.Entity.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mandarParametros(View view){
        boolean aa = true;
        boolean bb = true;
        boolean cc = true;
        boolean dd = true;
        boolean ee = true;
        boolean ff = true;

        TextView textViewNombre = findViewById(R.id.nomcam);
        String nomcam = textViewNombre.getText().toString();

        TextView textViewApellido = findViewById(R.id.apecam);
        String apecam = textViewApellido.getText().toString();

        TextView textViewCod = findViewById(R.id.codcam);
        String ccc = textViewCod.getText().toString();
        int codcam = 0;

        TextView textViewEspecialidad = findViewById(R.id.espcam);
        String espcam = textViewEspecialidad.getText().toString();

        TextView textViewDNI = findViewById(R.id.dnicam);
        String ddd = textViewDNI.getText().toString();
        int dnicam = 0;

        TextView textViewCam = findViewById(R.id.clavecam);
        String clavecam = textViewCam.getText().toString();

        if (nomcam.isEmpty()){
            textViewNombre.setError("Este campo no puede quedar vacio");
            aa = false;
        }
        if (apecam.isEmpty()){
            textViewApellido.setError("Este campo no puede quedar vacio");
            bb = false;
        }
        /////////////////////////////////////////////////////////////
        if (ccc.isEmpty()){
            textViewCod.setError("Este campo no puede quedar vacio");
            cc = false;
        }else{
            try {
                codcam = Integer.parseInt(ccc);
                if(ccc.length()!=8){
                    textViewCod.setError("Debe ingresar un codigo de 8 cifras");
                    cc = false;
                }else if(codcam<20120000 || codcam>20179999){
                    textViewCod.setError("Debe ingresar un codigo valido entre 2012XXXX y 2017XXXX");
                    cc = false;
                }
            }catch (NumberFormatException e){
                textViewCod.setError("Debe ingresar un numero");
                cc = false;
            }
        }

        if (espcam.isEmpty()){
            textViewEspecialidad.setError("Este campo no puede quedar vacio");
            dd = false;
        }
        //////////////////////////////////////////////////////////////
        if (ddd.isEmpty()){
            textViewDNI.setError("Este campo no puede quedar vacio");
            ee = false;
        }else{
            try {
                dnicam = Integer.parseInt(ddd);
                if(ddd.length()!=8){
                    textViewDNI.setError("Debe ingresar un valor numerico de 8 cifras");
                    ee = false;
                }
            }catch (NumberFormatException e){
                textViewDNI.setError("Debe ingresar un valor numerico");
                ee = false;
            }
        }

        if (clavecam.isEmpty()){
            textViewCam.setError("Este campo no puede quedar vacio");
            ff = false;
        }else if(!clavecam.equals("S3cr3t306")){
            textViewCam.setError("Clave incorrecta");
            ff = false;
        }

        if(aa && bb && cc && dd && ee && ff){
            //Usuario usu = new Usuario(codcam,nomcam,apecam,espcam,dnicam,clavecam);
            Intent intent = new Intent(MainActivity.this,tareas_pendientes.class);
            intent.putExtra("usu",new Usuario(codcam,nomcam,apecam,espcam,dnicam,clavecam));
            startActivity(intent);
            System.out.println();
        }
    }

}