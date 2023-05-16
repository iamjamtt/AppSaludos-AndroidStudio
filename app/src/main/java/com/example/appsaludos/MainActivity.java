package com.example.appsaludos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name; // variable nombre del formulario
    EditText edad; // variable edad del formulario
    EditText celular; // variable celular del formulario
    EditText email; // variable email del formulario

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // campo de textos
        name = findViewById(R.id.txt_name);
        edad = findViewById(R.id.txt_edad);
        celular = findViewById(R.id.txt_celular);
        email = findViewById(R.id.txt_email);
    }

    public void saludar(View view) {

        // Obtén los valores ingresados por el usuario
        String str_name = name.getText().toString().trim();
        String str_edad = edad.getText().toString().trim();
        String str_celular = celular.getText().toString().trim();
        String str_email = email.getText().toString().trim();

        // Validación del campo de texto (máximo 50 caracteres)
        if (str_name.length() > 50) {
            name.setError("Máximo 50 caracteres permitidos");
            return;
        }

        // Validación del campo número (rango de 0 a 99)
        int number;
        try {
            number = Integer.parseInt(str_edad);
            if (number < 0 || number > 99) {
                edad.setError("El número debe estar entre 0 y 99");
                return;
            }
        } catch (NumberFormatException e) {
            edad.setError("Ingrese un número válido");
            return;
        }

        // Validación del campo teléfono (9 dígitos)
        if (str_celular.length() != 9) {
            celular.setError("Ingrese un número de teléfono válido");
            return;
        }

        // Validación del campo email (formato correcto)
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(str_email).matches()) {
            email.setError("Ingrese una dirección de correo electrónico válida");
            return;
        }

        // Si todas las validaciones son exitosas, continúa con la lógica de envío o acción deseada
        String criterio_validacion = "";
        int get_edad = Integer.parseInt(str_edad);
        if(get_edad >= 0 && get_edad <= 2){
            criterio_validacion = "bebe";
        }else if(get_edad >= 3 && get_edad <= 12){
            criterio_validacion = "niño";
        }else if(get_edad >= 13 && get_edad <= 18){
            criterio_validacion = "adolecente";
        }else if(get_edad >= 19 && get_edad <= 50){
            criterio_validacion = "adulto";
        }else if(get_edad > 50){
            criterio_validacion = "anciano";
        }

        // mostrar como notificacion el resultado
        Toast.makeText(this, "Hola " + str_name + " eres un " + criterio_validacion + ".", Toast.LENGTH_LONG).show();
    }
}