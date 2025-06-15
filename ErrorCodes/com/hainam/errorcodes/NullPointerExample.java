package com.hainam.errorcodes;

import java.util.logging.Logger;

public class NullPointerExample {
    private static final Logger logger = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = null;

        if (text != null && !text.isEmpty()) {
            logger.info("Text is not empty");
        } else {
            logger.warning("Text is null or empty");
        }
    }
}
