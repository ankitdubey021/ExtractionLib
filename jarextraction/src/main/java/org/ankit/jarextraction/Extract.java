package org.ankit.jarextraction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.io.File;

/**
 * Created by Administrator on 11/2/2017.
 */

public class Extract extends ActivityCompat{
    public static void extract(File jarfile, String path)throws Exception{


        java.util.jar.JarFile jar = new java.util.jar.JarFile(jarfile);
        java.util.Enumeration enums = jar.entries();

        while (enums.hasMoreElements()) {
            java.util.jar.JarEntry file = (java.util.jar.JarEntry) enums.nextElement();
            java.io.File myFile=new java.io.File(path);
            if(!myFile.exists())
                myFile.mkdir();

            java.io.File f = new java.io.File(myFile + java.io.File.separator + file.getName());
            if (file.isDirectory()) { // if its a directory, create it
                f.mkdir();
                continue;
            }

            java.io.InputStream is = jar.getInputStream(file); // get the input stream
            java.io.FileOutputStream fos = new java.io.FileOutputStream(f);
            while (is.available() > 0) {  // write contents of 'is' to 'fos'
                fos.write(is.read());
            }

            fos.close();
            is.close();
        }
    }


}
