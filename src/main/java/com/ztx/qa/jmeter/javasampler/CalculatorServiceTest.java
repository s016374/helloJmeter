package com.ztx.qa.jmeter.javasampler;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

/**
 * Created by s016374 on 15/8/28.
 */
public class CalculatorServiceTest implements JavaSamplerClient{

    private SampleResult sampleResult;
    private String anIntA;
    private String anIntB;
    

    public void setupTest(JavaSamplerContext javaSamplerContext) {
        sampleResult = new SampleResult();
    }

    public SampleResult runTest(JavaSamplerContext javaSamplerContext) {
        anIntA = javaSamplerContext.getParameter("anIntA");
        anIntB = javaSamplerContext.getParameter("anIntB");

        sampleResult.sampleStart();
        try {
            System.out.println("...Start Test...");
            CalculatorService calculatorService = new CalculatorService();
            calculatorService.testMethod(Integer.parseInt(anIntA), Integer.parseInt(anIntB));
            sampleResult.setSuccessful(true);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            sampleResult.sampleEnd();
            System.out.println("...End Test...");
        }

        return sampleResult;
    }

    public void teardownTest(JavaSamplerContext javaSamplerContext) {

    }

    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("anIntA", "11");
        arguments.addArgument("anIntB", "22");
        return arguments;
    }
}