/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.*;
import java.net.*;

/**
 *
 * @author nicolasbuitrago
 */
public class Conector {
    Socket cliente;
    int puerto = 9000;
    String ip = "172.17.8.48";
    BufferedReader entrada, teclado;
    PrintStream salida;
    
    
    public void iniciar(){
        try {
            cliente =  new Socket(ip,puerto);
            entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            teclado =  new BufferedReader(new InputStreamReader(System.in));
            
            String tec = teclado.readLine();
            salida  =  new PrintStream(cliente.getOutputStream());
            salida.println(tec);
            
            String respuesta = entrada.readLine();
            
            System.out.println(respuesta);
            
            entrada.close();
            salida.close();
            teclado.close();
            cliente.close();
        } catch (Exception e) {
        }
    }
}
