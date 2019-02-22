/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import util.FileUtil;

/**
 *
 * @author Goshgar
 */
public class TCPServer {

    public static void main(String[] args) throws Exception {
       
    }

    public static String send(String path) throws Exception {
        Socket socket = new Socket("192.168.137.159", 8080);
        OutputStream outputStream = socket.getOutputStream();
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(image, FileUtil.getExtension(path), byteArrayOutputStream);
        byte[] size = ByteBuffer.allocate(4).putInt(byteArrayOutputStream.size()).array();
        outputStream.write(size);
        outputStream.write(byteArrayOutputStream.toByteArray());
        outputStream.flush();
        System.out.println("Flushed: " + System.currentTimeMillis());
        System.out.println("Closing: " + System.currentTimeMillis());
        socket.close();
        return file.getName();
    }
}
