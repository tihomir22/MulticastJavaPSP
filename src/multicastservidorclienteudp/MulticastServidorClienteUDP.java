/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multicastservidorclienteudp;

/**
 *
 * @author mati
 */
public class MulticastServidorClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Servidor server = new Servidor("Dembow server");
        Cliente cli = new Cliente("Dembow cliente");
        Cliente cli2 = new Cliente("Dembow cliente2");
        Cliente cli3 = new Cliente("Dembow cliente3");
        server.start();
        cli.start();
        cli2.start();
        cli3.start();
    }

}
