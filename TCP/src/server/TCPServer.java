/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Goshgar
 */
public class TCPServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8800);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStreamReader inputStream = new InputStreamReader(socket.getInputStream());
            InputStream in = socket.getInputStream();
            OutputStream out = new FileOutputStream("C:\\Users\\Goshgar\\Desktop\\et.exe");
            byte buffer[] = new byte[8192];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            System.out.println("All Done!!");
        }

    }

    public static void receive(String newPath, byte lines[]) throws Exception {
        try (FileOutputStream stream = new FileOutputStream(newPath)) {
            stream.write(lines);
        }

    }
}
