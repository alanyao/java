package com.yao;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReaderStrategy {

    private String _code;
    private Class _target;
    private List<FieldExtractor> extractors = new ArrayList<FieldExtractor>();

    public ReaderStrategy(String code, Class target) {
        _code = code;
        _target = target;
    }

    public Object prcoess(String line) {
        try {
            Object result = _target.newInstance();
            for (FieldExtractor ex : extractors)
                ex.extractField(line, result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String code() {
        return _code;
    }

    public void addFieldExtractor(int begin, int end, String target) {
        if (!targetPropertyNames().contains(target))
            throw new NoFieldInTargetException(target, _target.getName());
        extractors.add(new FieldExtractor(begin, end, target));
    }

    private List<String> targetPropertyNames() {
        List<String> result = new ArrayList<String>();
        for (Field f : _target.getDeclaredFields()) {
            result.add(f.getName());
        }
        return result;
    }

}
