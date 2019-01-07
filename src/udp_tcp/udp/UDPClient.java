package udp_tcp.udp;

import java.io.*;
import java.net.*;

class UDPClient
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader inFromUser =
                new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];

        while (true)
        {
            String sentence = inFromUser.readLine();

            if (sentence.equals("QUIT"))
            {
                System.out.println("Session quit");
                break;
            }
            else
            {
                sendData = sentence.getBytes();

                // Constructs a datagram packet for sending packets of length length to the specified port number on the specified host.
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);

                // Constructs a DatagramPacket for receiving packets of length length.
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedSentence = new String(receivePacket.getData());
                System.out.println("FROM SERVER:" + modifiedSentence);
            }
        }
        clientSocket.close();
    }
}
