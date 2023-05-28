package com.agorafob.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

import static com.agorafob.util.AppConstants.PROPERTY_FILE_NAME;

public class AppConfig {
    private static final Properties APP_CONFIG = new Properties();

    public static void initAppConfig() throws URISyntaxException, IOException {
        URL resources = AppConfig.class.getClassLoader().getResource(PROPERTY_FILE_NAME);
        APP_CONFIG.load(new FileReader(Objects.requireNonNull(resources).getFile()));
//        File file = Paths.get(Objects.requireNonNull(resources).toURI()).toFile();
//        String path = file.getAbsolutePath();
//        APP_CONFIG.load(new FileReader(path));
    }

    public static String getProperty(String key) {
        return APP_CONFIG.getProperty(key);
    }
}
