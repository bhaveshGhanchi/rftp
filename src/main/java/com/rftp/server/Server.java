package com.rftp.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args){

        try {
            int port  =4040;
            DatagramSocket s =  new DatagramSocket(port);
            System.out.println("Server started at: "+port);

            byte[] buffer = new byte[65535];

            while(true){
                DatagramPacket p = new DatagramPacket(buffer, buffer.length);
                s.receive(p);
                String message = new String(p.getData(),0,p.getLength());

                System.out.println("Recieved: "+ message);
                System.out.println("From: "+ p.getAddress()+" "+p.getPort() +" "+p.getLength());
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}