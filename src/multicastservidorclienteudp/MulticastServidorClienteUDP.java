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
        Servidor server = new Servidor("Servidor 1 ");
        Cliente cli = new Cliente("Cliente 1 > ");
        Cliente cli2 = new Cliente("Cliente 2 > ");
        Cliente cli3 = new Cliente("Cliente 3 > ");
        server.start();
        cli.start();
        cli2.start();
        cli3.start();
    }

}
