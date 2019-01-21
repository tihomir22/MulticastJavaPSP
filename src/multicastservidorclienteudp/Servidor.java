/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastservidorclienteudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Servidor extends Thread {

    String nombreServidor;
    int puertoServidor = 5000;
    byte[] buffer = new byte[1024];

    public Servidor(String nombreServidor) {
        this.nombreServidor = nombreServidor;
    }

    @Override
    public void run() {

        try {
            String ipMulti = "225.0.0.0";
            InetAddress addr = InetAddress.getByName(ipMulti);
            DatagramSocket socket_servidor = new DatagramSocket();
            int i = 0;
            while (i <= 100) {
                buffer = new byte[1024];
                String mensaje = "PORCENTAJE " + i + " %";
                System.out.println("SERVIDOR > Iniciado servidor UDP");

                DatagramPacket paquete_recibido = new DatagramPacket(mensaje.getBytes(), mensaje.length(), addr, this.puertoServidor);
                System.out.println("SERVIDOR > Enviando paquete por multicast " + mensaje);
                socket_servidor.send(paquete_recibido);
                System.out.println("SERVIDOR > Mensaje enviado con exito");
                Thread.sleep(1000);
                i = i + 10;

            }
        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
