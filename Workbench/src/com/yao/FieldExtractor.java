package com.yao;

import java.lang.reflect.Field;

public class FieldExtractor {
    
    private int _begin;
    private int _end;
    private String _targetPropertyName;

    public FieldExtractor(int begin, int end, String target) {
        _begin = begin;
        _end = end;
        _targetPropertyName = target;
    }

    public void extractField(String line, Object targetObject) {
        String value = line.substring(_begin, _end + 1);
        setValue(targetObject, value);
    }

    private void setValue(Object targetObject, String value) {
        try {
            Field f = targetObject.getClass().getDeclaredField(_targetPropertyName);
            f.setAccessible(true);
            f.set(targetObject, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
