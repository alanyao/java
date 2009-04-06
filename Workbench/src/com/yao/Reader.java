package com.yao;

import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reader {
    public List process(LineNumberReader lnr) throws IOException {
        try {
            List result = new ArrayList();
            String line;
            while ((line = lnr.readLine()) != null)
                processLine(line, result);
            return result;
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private void processLine(String line, List result) {
        if (isBlank(line))
            return;
        if (isComment(line))
            return;
        String typeCode = getTypeCode(line);
        ReaderStrategy strategy = _strategies.get(typeCode);
        if (strategy == null)
            throw new RuntimeException("Unable to find strategy");
        result.add(strategy.prcoess(line));
    }

    private String getTypeCode(String line) {
        return line.substring(0, 4);
    }

    private boolean isComment(String line) {
        return line.startsWith("#");
    }

    private boolean isBlank(String line) {
        return line.equals("");
    }

    Map<String, ReaderStrategy> _strategies = new HashMap<String, ReaderStrategy>();

    public void addStrategy(ReaderStrategy arg) {
        _strategies.put(arg.code(), arg);
    }

}
