package sample;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConexionHilo {


    public static  Socket conectar(int puerto, String ip) throws IOException {
        Socket clienteSocket = new Socket();
        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
        clienteSocket.connect(addr);

        return clienteSocket;
    }

    public static void enviarMensaje(Socket clienteSocket,ClaseMensaje mensaje) throws IOException {


        InputStream is = clienteSocket.getInputStream();
        OutputStream os= clienteSocket.getOutputStream();
        String operacion="";
        operacion = operacion+",";
        os.write(operacion.getBytes());

        byte[] resultado = new byte[25];
        is.read(resultado);

        String resul = new String(resultado);
    }

    public static void cerrarSocket(Socket clienteSocket) throws IOException {
        clienteSocket.close();
    }
}
