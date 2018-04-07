package com.tsystems.javaschoolshop.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;


/**
 * This Util exists for helping developers to save different images into
 * server physical memory inside apache tomcat catalog
 */
public class ImageUtil {

    /**
     * path to the folder where image will be saved
     */
    private static final String IMAGES = "image\\food\\item";
    /**
     * Path to the root folder
     */
    private static final String ROOT_PATH = "webapps\\ROOT\\resources";

    /**
     * Absolute path to the  root folder
     */
    private static final String ABSOLUTE_ROOT_PATH = System.getProperty("catalina.home") + File.separator  + ROOT_PATH+ File.separator;

    /**
     * Path to the images folder inside the tomcat root catalog
     */
    private static final String IMAGES_PATH = ABSOLUTE_ROOT_PATH +IMAGES;

    /**
     * Field which stores Java API of images folder
     */
    private static final File IMAGES_DIR = new File(IMAGES_PATH);

    /**
     * Absolute path to the images folder inside the tomcat root catalog
     */
    private static final String IMAGES_DIR_ABSOLUTE_PATH = IMAGES_DIR.getAbsolutePath();

    /**
     * Empty constructor
     */
    private ImageUtil() {

    }

    /**
     * Method saves some file into images folder(it is assumed the this will be a picture)
     *
     * @param name - Future name of the saving file
     * @param file - Directly, the file itself
     */
    public static void uploadImage(String name, MultipartFile file) {
        File image = new File(IMAGES_DIR_ABSOLUTE_PATH  + name + ".jpeg");
        try (BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(image))) {
            stream.write(file.getBytes());
            stream.close();
        } catch (Exception e) {
        }
    }

    /**
     * Method creates images directory if it doesn't exist
     */
    public static void createImagesDirectoryIfNeeded() {
        if (!IMAGES_DIR.exists()) {
            IMAGES_DIR.mkdirs();
        }
    }

    public static String getAbsoluteRootPath() {
        return ABSOLUTE_ROOT_PATH;
    }
}
