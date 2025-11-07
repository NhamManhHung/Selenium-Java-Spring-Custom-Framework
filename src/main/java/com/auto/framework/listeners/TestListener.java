package com.auto.framework.listeners;

import io.qameta.allure.Allure;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.internal.TestResult;

import io.qameta.allure.AllureLifecycle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestListener extends TestListenerAdapter {

    @Override
    public void onStart(ITestContext context) {
        log.info("========== TestNG Suite Started on Thread: {} ==========",
                Thread.currentThread().getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("========== TestNG Suite Finished on Thread: {} ==========",
                Thread.currentThread().getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        log.info("[START] Test '{}' | Thread: {}",
                result.getMethod().getMethodName(),
                Thread.currentThread().getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[PASS] Test '{}' | Thread: {}",
                result.getMethod().getMethodName(),
                Thread.currentThread().getName());
        testReportUpdate(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("[FAIL] Test '{}' | Thread: {} | Error: {}",
                result.getMethod().getMethodName(),
                Thread.currentThread().getName(),
                result.getThrowable() != null ? result.getThrowable().getMessage() : "N/A");
        testReportUpdate(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        log.info("[SKIPPED] Test '{}' | Thread: {}",
                result.getMethod().getMethodName(),
                Thread.currentThread().getName());
        testReportUpdate(result);
    }

    public void testReportUpdate(ITestResult iTestResult) {
        String testSetNumber = iTestResult.getName() + " " + (((TestResult) iTestResult).getParameterIndex() + 1);
        AllureLifecycle lifecycle = Allure.getLifecycle();
        if (lifecycle.getCurrentTestCase().isPresent()) {
            lifecycle.updateTestCase(testResult -> testResult.setName(testSetNumber));
        }
        log.info("[Allure] Updated test name to '{}'", testSetNumber);
    }
}