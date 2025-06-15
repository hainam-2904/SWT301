package com.hainam.exception;

import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        String s = "Hello SonarQube"; // Giả lập giá trị thực tế

        try {
            if (s != null) {
                logger.info(() -> String.format("Length: %d", s.length()));
            } else {
                logger.warning("String is null");
            }
        } catch (NullPointerException ignored) {
            logger.severe("NullPointerException occurred");
        }
    }
}
