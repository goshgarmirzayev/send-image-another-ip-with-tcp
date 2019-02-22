package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.file.Files;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Goshgar
 */
public class FileUtil {

    public static File file;

    public static byte[] readFile() throws Exception {
        byte[] allBytes = Files.readAllBytes(file.toPath());
        return allBytes;
    }

    public static void writeToFile() throws Exception {
        FileOutputStream out = new FileOutputStream("C:\\Users\\Goshgar\\ReceivedImage.jpg");
        out.write(readFile());
    }

    public static String getExtension(String path) {
        String extension = "";
        int i = path.lastIndexOf('.');
        if (i > 0) {
            extension = path.substring(i + 1);
        }
        return extension;
    }
}
