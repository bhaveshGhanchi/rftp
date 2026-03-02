package com.rftp.client;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args){
        try {
            DatagramSocket s = new DatagramSocket();
            
            // byte[] buffer = message.getBytes();
            InetAddress add = InetAddress.getByName("localhost");
            int port = 4040;

            

                // String message = "Hello RFTP";
                String message = "A".repeat(70000);
                byte[] buffer = message.getBytes();
                DatagramPacket p  = new DatagramPacket(buffer, buffer.length,add, port);
                s.send(p);
                System.out.println("Message  send");
                System.out.println("Client sending bytes: " + buffer.length);


            s.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
