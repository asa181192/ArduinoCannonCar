package techgen.uicar;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.widget.Toast;

import java.io.IOException;
import java.util.UUID;

/**
 * Codigo Por parte de la Documentacion de Android
 * https://developer.android.com/guide/topics/connectivity/bluetooth.html
 * Solamente se hicieron cambios minimos para adaptarlo al codigo del proyecto
 */
public class hiloBluetooth extends Thread {
    private static BluetoothSocket mmSocket;
    private final BluetoothDevice mmDevice;
    private static boolean listo = false  ;
     private static int position;
    public hiloBluetooth (BluetoothDevice device) {

        UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");//ESTE UUID CORRESPONDE A UN MODULO HC-05/06 DE BLUETOOTH
        BluetoothSocket tmp = null;

        mmDevice = device;

        try {
            tmp = device.createRfcommSocketToServiceRecord(MY_UUID);
        } catch (IOException e) { }
        mmSocket = tmp;
    }

    public void run() {


        try {

            mmSocket.connect();
            listo=true;//VARIABLE BOOLEANA PARA SABER SI SE ESTA CONECTADO A EL DISPOSITIVO BLUETOOTH
        } catch (IOException connectException) {

            try {
                mmSocket.close();
                listo=false;
            } catch (IOException closeException) { }
            return;
        }

             new ConnectedThread(mmSocket);//SE REALIZA EL ENVIO DE INFORMACION POR PARTE DE OTRO HILO
    }

    public static boolean GetBoolean() {
        return listo;
    }

    public static void cancel() {
        try {
            listo=false;
            mmSocket.close();
        } catch (IOException e) { }
    }
}
