package com.yao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        Reader r = new Reader();
        Example example = new Example();
        example.configure(r);
        InputStream is = MainClass.class.getResourceAsStream("data");
        LineNumberReader lnr = new LineNumberReader(new InputStreamReader(is));
        try {
            List result = r.process(lnr);
            System.out.println(result);
        } catch (IOException ioe) {
          throw new RuntimeException(ioe);  
        } finally {
            try { lnr.close(); } catch(Exception e) {}
        }
    }
}
