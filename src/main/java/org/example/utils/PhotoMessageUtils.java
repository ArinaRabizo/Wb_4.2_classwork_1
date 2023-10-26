package org.example.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


import org.telegram.telegrambots.meta.api.objects.File;

public class PhotoMessageUtils {

    public static List<String> savePhotos (List<File> files, String botToken) throws IOException{
        Random random = new Random();
        ArrayList <String> paths = new ArrayList<>();
        for (File file: files) {
            final String imageUrl = "https://api.telegram.org/file/bot" + botToken + "/" + file.getFilePath();
            final String localFileName = "images/" + new Date().getTime() + random.nextLong() + ".jpeg";
            saveImage(imageUrl, localFileName);
            paths.add(localFileName);
        }
        return paths;
    }

    public static void saveImage(String URL, String filename) throws IOException {
        URL urlModel = new URL(URL);
        InputStream InputStream = urlModel.openStream();
        OutputStream outputStream = new FileOutputStream(filename);
        byte[] b = new byte[2048];
        int length;
        while ((length = InputStream.read(b)) != -1) {
            outputStream.write(b, 0, length);
        }
        InputStream.close();
        outputStream.close();

    }

}
