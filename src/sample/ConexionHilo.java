package sample;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ConexionHilo {


    public static  Socket conectar(int puerto, String ip) throws IOException {
        Socket clienteSocket = new Socket();
        InetSocketAddress addr = new InetSocketAddress(ip, puerto);
        clienteSocket.connect(addr);
        System.out.println("Entre metodo clase ConexionHilo");
        return clienteSocket;
    }

    public static void enviarMensaje(Socket clienteSocket,ClaseMensaje mensaje) throws IOException {

        ObjectOutputStream oos = null;
        oos = new ObjectOutputStream(clienteSocket.getOutputStream());

        oos.writeObject(mensaje);
        System.out.println("Mensaje enviado");
    }

    public static void cerrarSocket(Socket clienteSocket) throws IOException {
        clienteSocket.close();
    }
}
