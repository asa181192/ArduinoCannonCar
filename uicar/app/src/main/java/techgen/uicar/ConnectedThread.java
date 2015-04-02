package techgen.uicar;

import android.bluetooth.BluetoothSocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Codigo Por parte de la Documentacion de Android
 * https://developer.android.com/guide/topics/connectivity/bluetooth.html
 */
public class ConnectedThread extends Thread {
    private final BluetoothSocket mmSocket;
    private final InputStream mmInStream;
    private static OutputStream mmOutStream=null;

    public ConnectedThread(BluetoothSocket socket) {
        mmSocket = socket;
        InputStream tmpIn = null;
        OutputStream tmpOut = null;

        try {
            tmpIn = socket.getInputStream();
            tmpOut = socket.getOutputStream();
        } catch (IOException e) { }

        mmInStream = tmpIn;
        mmOutStream = tmpOut;
    }

    public void run() {
        byte[] buffer = new byte[1024];
        int bytes; //
        while (true) {
            try {

                bytes = mmInStream.read(buffer);//LEE POR PUERTO SERIAL BYTES ENTRANTES

            } catch (IOException e) {
                break;
            }
        }
    }// Este Metodo no esta en uso , sin embargo se usa para cuando se necesite recibir informacion por comunicacion Serial .

    public static void write(byte bytes) {
        try {
            mmOutStream.write(bytes);
        } catch (IOException e) { }
    }//ESTE METODO NOS PERMITE ESCRIBIR POR PUERTO SERIAL

    public void cancel() {
        try {
            mmSocket.close();
        } catch (IOException e) { }
    }//ESTE METODO SE LLAMA DESDE LA ACTIVIDAD PRINCIPAL CUANDO SE NECESITE FINALIZAR CON LA CONECCION
}