package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.Socket;

public class Controller {

    @FXML
    private Button conectarB;
    @FXML
    private TextField ip;
    @FXML
    private TextField puerto;
    @FXML
    private TextField nickname;
    @FXML
    private Label cuerpoChat;
    @FXML
    private TextField mensaje;
    @FXML
    private Button enviar;
    @FXML
    private Button desconectarB;

    public ClaseMensaje objetoMensaje;
    public Socket socketCliente;

    @FXML
    void conectar(javafx.event.ActionEvent event) throws IOException {

        System.out.println("Entre metodo Controller");
        String ipS = ip.getText();
        String puertoS = puerto.getText();
        int puertoI = Integer.parseInt(puertoS);
        String nicknameS = nickname.getText();
        objetoMensaje = new ClaseMensaje(nicknameS);
        socketCliente=ConexionHilo.conectar(puertoI,ipS);
    }

    @FXML
    void desconectar(javafx.event.ActionEvent event) throws IOException {
        ConexionHilo.cerrarSocket(socketCliente);
    }

    @FXML
    void enviarMensaje(javafx.event.ActionEvent event) throws IOException {
        String mensajeS = mensaje.getText();
        objetoMensaje.setMensaje(mensajeS);
        ConexionHilo.enviarMensaje(socketCliente,objetoMensaje);

    }
}