package com.ztx.qa.jmeter.javasampler;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

import java.io.FileNotFoundException;

/**
 * Created by s016374 on 15/8/28.
 */
public class PerformenceTest implements JavaSamplerClient {

    private SampleResult sampleResult;
    private String filename;
    private String a;
    private String b;

    public void setupTest(JavaSamplerContext javaSamplerContext) {
        sampleResult = new SampleResult();
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        filename = javaSamplerContext.getParameter("filename");
        a = javaSamplerContext.getParameter("a");
        b = javaSamplerContext.getParameter("b");

        sampleResult.sampleStart();
        try {
            OutputService outputService = new OutputService();
            outputService.output(filename, Integer.parseInt(a), Integer.parseInt(b));
            sampleResult.setSuccessful(true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            sampleResult.sampleEnd();
        }

        return sampleResult;
    }

    public void teardownTest(JavaSamplerContext javaSamplerContext) {

    }

    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("filename", "0");
        arguments.addArgument("a", "0");
        arguments.addArgument("b", "0");
        return arguments;
    }

    public static void main(String args[]) {
        Arguments arguments = new Arguments();
        arguments.addArgument("a", "1");
        arguments.addArgument("b", "2");
        arguments.addArgument("filename", "/Users/s016374/Desktop/redis.properties");

        JavaSamplerContext javaSamplerContext = new JavaSamplerContext(arguments);
        PerformenceTest performenceTest = new PerformenceTest();
        performenceTest.setupTest(javaSamplerContext);
        performenceTest.runTest(javaSamplerContext);
        performenceTest.teardownTest(javaSamplerContext);
    }
}
