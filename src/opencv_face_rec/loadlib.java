/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencv_face_rec;

import java.io.File;
import java.io.InputStream;
import javax.swing.JOptionPane;
import org.opencv.core.Core;

/**
 *
 * @author Saliya
 */
public class loadlib {

    public static void loadLibraries() {

        try {
            String osName = System.getProperty("os.name");
            String opencvpath = System.getProperty("user.dir");
            if (osName.startsWith("Windows")) {
                int bitness = Integer.parseInt(System.getProperty("sun.arch.data.model"));
                switch (bitness) {
                    case 32:
                        opencvpath = opencvpath + "\\x86\\";
                        break;
                    case 64:
                        opencvpath = opencvpath + "\\x64\\";
                        break;
                    default:
                        opencvpath = opencvpath + "\\x86\\";
                        break;
                }
            } else if (osName.equals("Mac OS X")) {
                opencvpath = opencvpath + "Your path to .dylib";
            }
            //System.out.println(opencvpath);
            System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");
        } catch (Exception e) {
            // throw new RuntimeException("Failed to load opencv native library", e);
            JOptionPane.showMessageDialog(null, "Failed to load opencv native library !");
        }
    }
}
