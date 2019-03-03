/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpclient;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

/**
 *
 * @author Goshgar
 */
public class TCPClient {

    public static void main(String argv[]) throws Exception {
        try (Socket socket = new Socket("localhost", 8800)) {
            DataOutputStream dat = new DataOutputStream(socket.getOutputStream());
            byte bytes[] = getAllBystesFromFIle("C:\\Program Files\\NetBeans 8.2\\bin\\netbeans64.exe");
            dat.write(bytes);
        }

    }

    public static byte[] getAllBystesFromFIle(String filePath) throws Exception {
        byte[] bysteArray = null;
        try (FileInputStream fis = new FileInputStream(filePath);) {
            File file = new File(filePath);
            bysteArray = new byte[(int) file.length()];
            fis.read(bysteArray);
        }

        return bysteArray;
    }
}
