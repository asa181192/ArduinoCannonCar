package techgen.uicar;


import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;


//@autor Alfredo Santiago 15/02/2015
/***Cambios***
 * 1/03/2015 Corregido el sistema de manejo - Ahora el carro avanza solamente el tiempo que se deja aplanado el boton de avanze al soltar se detiene el carro (Metodos Motion)
 *
 *
 */


public class ActividadInicial extends ActionBarActivity {

    private BluetoothAdapter adapter;
    private ArrayAdapter<String> arreglo ;
    private Button btnAdelante,btnAtras,btnIzquierda,btnDerecha,btnBomba,btnServoUP,btnServoDown;
    private Switch mySwitch ;
    private SeekBar miServo ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_inicial);
            btnAdelante = (Button) findViewById(R.id.adelante);
            btnAtras = (Button) findViewById(R.id.Atras);
            btnIzquierda = (Button) findViewById(R.id.izq);
            btnDerecha = (Button) findViewById(R.id.der);
            btnBomba = (Button) findViewById(R.id.bomba);
            mySwitch = (Switch) findViewById(R.id.switch1);
            mySwitch.setChecked(false);
            miServo = (SeekBar) findViewById(R.id.seekBar);
        adapter=BluetoothAdapter.getDefaultAdapter();// creamos un adaptador , para saber si el dispositivo cuenta con bluetooth

            if(adapter==null){
                Log.d("logBluetooth","No bluetooth");

            }//Identifica si el dispositivo hace uso de bluetooth
                else {
                Log.d("logBleutooth","Si hay un bluetooth en el dispositivo "); // puedes finalizar la applicacion en caso de que no cuente .
            }
            Bomba(); //Activa la bomba d agua
            Myswitch();//Activa el laser de mirilla
            Adelante();//Acelera el Carro hacia adelante
            Reversa(); //Acelera el Carro hacia atras
            Derecha(); //Acelera el carro hacia la derecha
            Izquierda(); //Acelera el carro hacia la izquierda
            BarraServo();
         //   ServoUp();//Mueve el servomotor para apuntar la bomba hacia arriba
         //   servoDown();//Mueve el servomotor par  apuntar la bomba hacia abajo
 }// fin metodo onCreate

    private void Reversa () {

        btnAtras.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(hiloBluetooth.GetBoolean()==true) {

                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN :
                            byte a = 101;
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP :
                            byte b = 100;
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(),"Sincroniza primero el bluetooth",Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener
    }//Fin metodo reversa
    private void Derecha () {

        btnDerecha.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(hiloBluetooth.GetBoolean()==true) {

                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN :
                            byte a = 102;
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP :
                            byte b = 100;
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(),"Sincroniza primero el bluetooth",Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener

    }// Fin metodo derecha
    private void Adelante () {

        btnAdelante.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(hiloBluetooth.GetBoolean()==true) {

                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN :
                            byte a = 103;
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP :
                            byte b = 100;
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(),"Sincroniza primero el bluetooth",Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener

    }//Fin de metodo adelante
    private void Izquierda () {
        btnIzquierda.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(hiloBluetooth.GetBoolean()==true) {

                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN :
                            byte a = 104;
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP :
                            byte b = 100;
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(),"Sincroniza primero el bluetooth",Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener
    }//Fin Metodo Izquierda
    private void Bomba () {

        btnBomba.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(hiloBluetooth.GetBoolean()==true) {

                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN :
                            byte a = 107;
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP :
                            byte b = 100;
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(),"Sincroniza primero el bluetooth",Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener

    }//Fin metodo Bomba

    private  void Myswitch () {


                    mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if (isChecked) {
                                byte a = 108;
                                ConnectedThread.write(a);
                            } else {
                                byte b = 109;
                                ConnectedThread.write(b);
                            }
                        }
                    });


    }
    private void BarraServo () {


            miServo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                byte a;

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    ConnectedThread.write(a);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onProgressChanged(SeekBar seekBar, int progress,
                                              boolean fromUser) {
                    a = (byte) progress;
                }
            });



    }
    /*private void ServoUp () {
        btnServoUP.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if(hiloBluetooth.GetBoolean()==true) {

                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN :
                            byte a = 'Y';//Y
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP :
                            byte b= '0';
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(),"Sincroniza primero el bluetooth",Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener
    }*/
   /* private void servoDown () {
        btnServoDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (hiloBluetooth.GetBoolean() == true) {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            byte a = '=';//=
                            ConnectedThread.write(a);
                            break;
                        case MotionEvent.ACTION_UP:
                            byte b = '0';
                            ConnectedThread.write(b);
                            break;
                    }//Fin de switch

                }//Fin de if
                else {
                    Toast.makeText(getApplicationContext(), "Sincroniza primero el bluetooth", Toast.LENGTH_SHORT).show();
                }//Fin de else

                return false;
            }// Fin d e action On listener
        });//fin de set touc on listener
    }
*/
    public void on () {
        if (!adapter.isEnabled()){
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
            Log.d("Detectando si encendio bluetooth","bluetooth apagado");//fines de debug solamente.
            Toast.makeText(getApplicationContext(), "Acepta para encender bluetooth"
                    , Toast.LENGTH_LONG).show();
        }else {

            Toast.makeText(getApplicationContext(), "Bluetooth ya esta encendido"
                    , Toast.LENGTH_LONG).show();


        }// Este metodo enciende el bluetooth .
    }

    public void VentanaBluetooth () {

        Intent i = new Intent(this,BluetoothList.class);
        startActivity(i);


    }//este metodo devuelve una lista de todos los dispositivos conocidos "paired" de bluetooth

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_actividad_inicial, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id){
            case R.id.bluetoothMenu :
                on();
            break;
            case R.id.VentanaBluetooth :
                VentanaBluetooth();
            break;

        }


        return super.onOptionsItemSelected(item);
    }//Este Metodo nos devuelve la parte de ajustes en la aplicacion como activar el bluetooth o conectarse a algun dispositivo que ya haya sido ligado .
}
