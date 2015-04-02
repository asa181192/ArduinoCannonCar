package techgen.uicar;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;
//@autor Alfredo Santiago
/*--Cambios--

*/
public class BluetoothList extends ActionBarActivity  {


     private ArrayAdapter<String> arregloPantalla ;//Una muestra por pantalla en un listView los dispositivos ligados , la otra es para fines de conexion con la clase HiloBluetooth .
     private BluetoothAdapter adapter;// Creacion BluetoothAdapter nos funciona para regresarnos todos los dispositivos que ya han sido ligados anteriormente .
     private ListView lv1 ;//Muestra por pantalla todos los dispositivos ligados
     private  Set<BluetoothDevice> dispositivosLigados ;//Nos guarda en una lista todos los dispositivos .
     private  BluetoothDevice miDevice ;//Nos funciona para mandarlo al constructor de hiloBluetooth con la informacion de la MAC de un bluetooth .
     private hiloBluetooth mibluetooth;//Objeto para hacer la conexion con el dispositivo bluetooth previamente ligado .
     private TextView tv1 ;
     private ArrayList<String> arregloInterno;
     private  String[] nombre ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_list);
        ListaBluetooth();
        if(mibluetooth.GetBoolean()==true){
         Toast.makeText(this,"Ya hay un modulo conectado",Toast.LENGTH_SHORT).show();

        }
        tv1 = (TextView)findViewById(R.id.tvConectar);
        lv1= (ListView) findViewById(R.id.VistaBluetooth);
        lv1.setAdapter(arregloPantalla);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Log.d("*******SE PRESIONO SOBRE**********"," VALOR DE POSICION: "+position+" VALOR DE ID "+id    );
             //   hiloBluetooth mibluetooth = new hiloBluetooth(miDevice);

                miDevice= adapter.getRemoteDevice(arregloInterno.get(position));
                mibluetooth = new hiloBluetooth(miDevice);

                try {

                    mibluetooth.run();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if(mibluetooth.GetBoolean()==true){
                    nombre = arregloPantalla.getItem(position).split("\n");
                    tv1.setText("Conectado modulo : " +nombre[0] );
                    Toast.makeText(getApplicationContext(),"Conectado con exito",Toast.LENGTH_SHORT).show();

                }else if (mibluetooth.GetBoolean()==false){

                    Toast.makeText(getApplicationContext(),"No se a podido conectar",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void ListaBluetooth () {
        adapter=BluetoothAdapter.getDefaultAdapter();
        arregloInterno = new ArrayList<String>();
        arregloPantalla = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
       dispositivosLigados = adapter.getBondedDevices();
        if(dispositivosLigados.size()>0) {
            for (BluetoothDevice dispositivo : dispositivosLigados){
                arregloInterno.add(dispositivo.getAddress());
                arregloPantalla.add(dispositivo.getName()+"\nMAC: "+dispositivo.getAddress());

            }

        }
    }

    public void Cerrar (View view) {
     tv1.setText("Seleccione su modulo ");
     Toast.makeText(getApplicationContext(),"Conexion terminada",Toast.LENGTH_LONG).show();
     hiloBluetooth.cancel();
    }

}
