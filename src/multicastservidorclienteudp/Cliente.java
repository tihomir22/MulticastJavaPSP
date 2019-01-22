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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mati
 */
public class Cliente extends Thread {
    
    final int puertoServidor = 5000;
    byte[] buffer = new byte[1024];
    private String nombreCliente;
    
    public Cliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    @Override
    public synchronized void run() {
        try {
            String msg = "inicio";
            String ipMulti = "225.0.0.0";
            InetAddress address = InetAddress.getByName(ipMulti);
            byte[] buf = new byte[256];
            
            MulticastSocket socketMulticast = new MulticastSocket(this.puertoServidor);
            socketMulticast.joinGroup(address);
            while (!msg.equalsIgnoreCase(100 + "")) {
                if (msg.equalsIgnoreCase("inicio") && this.nombreCliente.equalsIgnoreCase("Cliente 3 > ")) {
                    Thread.sleep(2000);
                }
                DatagramPacket msgPacket = new DatagramPacket(buf, buf.length);
                socketMulticast.receive(msgPacket);
                msg = new String(msgPacket.getData());
                System.out.println(this.nombreCliente + " Hemos recibido " + msg);
                msg = msg.split(" ")[1];
                Thread.sleep(1000);
                
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
