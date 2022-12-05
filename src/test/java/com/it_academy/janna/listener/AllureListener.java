package com.it_academy.janna.listener;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.it_academy.janna.utils.ScreenshotUtil.takeScreenshotAndAttachToAllureReport;

public class AllureListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        takeScreenshotAndAttachToAllureReport();
    }
}
