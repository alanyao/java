package com.yao;

public class NoFieldInTargetException extends RuntimeException {
    public NoFieldInTargetException(String targetField, String target) {
        super("There is no Field '" + targetField + "' in class '" + target
                + "'.");
    }
}
