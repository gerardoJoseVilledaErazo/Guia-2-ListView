package com.example.sesion2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.sesion2.modelo.Persona;
import java.util.ArrayList;
public class RegistrarActivity extends AppCompatActivity {
    EditText edtNombre;
    Button btnGuardar;
    private ProgressBar pb;
    public static ArrayList<Persona> personas;
    boolean isActivo = false;
    int i = 0;
    Handler h = new Handler();
    TextView t;
    Intent x;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        edtNombre = (EditText) findViewById(R.id.edtNombre);
        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        t = (TextView) findViewById(R.id.porcentaje);
        personas = new ArrayList<>();
    }
    public void guardarRegistro(View view){
        if(edtNombre.getText().toString().isEmpty()==true){
            edtNombre.setError("campo obligatorio");
            edtNombre.requestFocus();
            return;
        }else{
            personas.add(new Persona(edtNombre.getText().toString() ));
            if(view.getId()==R.id.btnGuardar){            //
                if(!isActivo){                //
                    Thread hilo = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (i<=100){
                                h.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        t.setText(i + " %");
                                        pb.setProgress(i);
                                    }
                                });
                                try {
                                    Thread.sleep(10);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                if (i==100){
                                    x = new Intent(RegistrarActivity.this,ListarActivity.class);
                                    startActivity(x);
                                }
                                i++;
                                isActivo=true;
                            }
                        }
                    });
                    Toast.makeText(RegistrarActivity.this,"Guardado con éxito",Toast.LENGTH_SHORT).show();
                    hilo.start();
                }
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
    //Al dar clic en el botón “Cancelar”
    // debe borrar el texto o valor de todos los componentes del formulario.
    public void Cancel(View view) {
        edtNombre.setText("");
        pb.setProgress(0);
        i=0;
        isActivo=false;
        t.setText("0 %");
    }
}