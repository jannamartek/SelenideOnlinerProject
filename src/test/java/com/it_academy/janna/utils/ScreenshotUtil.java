package com.it_academy.janna.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

import static java.time.LocalDateTime.now;
import static org.apache.commons.io.FileUtils.openInputStream;

public class ScreenshotUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ScreenshotUtil.class);

    public ScreenshotUtil() {
    }

    public static void takeScreenshotAndAttachToAllureReport() {

        try {
            File screenshotAs = Screenshots.takeScreenShotAsFile();
            Allure.addAttachment("Screenshot " + now(), openInputStream(screenshotAs));
        } catch (IOException e) {
            e.printStackTrace();
            LOG.error("Error creating screenshot");
        }
    }
}
