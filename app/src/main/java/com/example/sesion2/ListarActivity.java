package com.example.sesion2;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.sesion2.modelo.Persona;
import java.util.ArrayList;
import static com.example.sesion2.RegistrarActivity.personas;
public class ListarActivity extends AppCompatActivity {
    ListView lsvPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);
        if ( getSupportActionBar() != null ) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        lsvPersonas = findViewById(R.id.lsvPersonas);
        ArrayAdapter<Persona> adaptadorPersona = new ArrayAdapter(this, android.R.layout.simple_list_item_1, personas);
        lsvPersonas.setAdapter(adaptadorPersona);
        adaptadorPersona.notifyDataSetChanged();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}