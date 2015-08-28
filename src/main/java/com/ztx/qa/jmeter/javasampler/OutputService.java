package com.ztx.qa.jmeter.javasampler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by s016374 on 15/8/28.
 */
public class OutputService {
    public static void output(String filename, int a, int b) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File(filename));
        out.write(a + ":" + b);
        out.close();
    }
}
