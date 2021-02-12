package cn.forgotdream.authdomain.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Print {
    public static final Logger LOGGER = LogManager.getLogger();

    public static void print_message(String Message) {
        LOGGER.info("[Authdomain] " + Message);
    }

    public static void print_warning(String Warning) {
        LOGGER.warn("[Authdomain] " + Warning);
    }
}
