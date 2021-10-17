package dam.esteban.u2p4conversor;

import android.os.Bundle;
import android.util.Log;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.DecimalFormat;



public class MainActivity extends LogActivity {
    //TODO: Formato


    DecimalFormat df = new DecimalFormat("#.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI(savedInstanceState);


    }

//TODO: Funcion setUI
    private void setUI(Bundle savedInstanceState){
//Obtenemos todos los campos por sus ids


        EditText editTextNumber= findViewById(R.id.editPulgada);
        EditText textoConversor= findViewById(R.id.textResultado);
        Button button= findViewById(R.id.button);
        Button buttonPU= findViewById(R.id.buttonPU);
        TextView textoErrores= findViewById(R.id.textoErrores);



        //Verificamos el save para ver si tiene datos guardados

        if (savedInstanceState!=null){
            textoErrores.setText(savedInstanceState.getString("error"));

        }

        //Añadimos evento al boton para despues llamar a la funcion de convertir
        button.setOnClickListener(view -> {

            try {
                textoConversor.setText(convertirCMPU(editTextNumber.getText().toString()));
            }catch (Exception e){

                Log.e("LogsConversor", e.getMessage());
                textoErrores.setText(e.getMessage());
            }
        });


        buttonPU.setOnClickListener(view -> {

            try {
                editTextNumber.setText(convertirPUCM(textoConversor.getText().toString()));

            }catch (Exception e){
                Log.e("LogsConversor", e.getMessage());
                textoErrores.setText(e.getMessage());
            }

        });






    }
//TODO: Funcion convertir de cm a pulgadas
    private String convertirCMPU( String pulgada) throws Exception {
    if (Integer.parseInt(pulgada)<=0){
        throw new Exception("Anañe un numero mayor a 0");
    }

        double pulgadaValue= Double.parseDouble(pulgada)*2.54;
        df.format(pulgadaValue);
        return  String.valueOf(pulgadaValue);
    }

    //TODO: Funcion convertir de pulgadas a cm
    private String convertirPUCM(String cm) throws Exception {

        if (Integer.parseInt(cm)<=0){
            throw new Exception("Anañe un numero mayor a 0");
        }

        DecimalFormat formato= new DecimalFormat();
        formato.setMaximumFractionDigits(2);


        double cmValue=Double.parseDouble(cm)/2.54;
        formato.format(cmValue);
        return String.valueOf(cmValue);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        TextView textoErr=findViewById(R.id.textoErrores);

        String textoErroresSave= textoErr.getText().toString();

        savedInstanceState.putString("error", textoErroresSave);


    }



}