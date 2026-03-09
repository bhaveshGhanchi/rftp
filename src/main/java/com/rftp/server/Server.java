package com.rftp.server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.rftp.packet.Packet;

public class Server {
    public static void main(String[] args){

        try {
            int port  =4040;
            DatagramSocket s =  new DatagramSocket(port);
            System.out.println("Server started at: "+port);

            byte[] buffer = new byte[65535];

            while(true){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                s.receive(packet);
                Packet parsed = Packet.fromBytes(packet.getData(), packet.getLength());

                System.out.println("Recieved: "+ parsed.getPayload().length + " bytes");
                System.out.println("Recieved: "+ new String(parsed.getPayload()));
                System.out.println("From: "+ packet.getAddress()+" "+packet.getPort() +" "+packet.getLength()+" "+parsed.getSequenceNumber());
                System.out.println("---------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}