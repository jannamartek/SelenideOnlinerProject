package com.it_academy.janna.framework;

import org.openqa.selenium.remote.DesiredCapabilities;

import static com.it_academy.janna.framework.OptionsManager.*;

public class CapabilityFactory {
    public static DesiredCapabilities capabilities;

    public static synchronized DesiredCapabilities getCapabilities(String browser) {
        switch (browser) {
            case "firefox" -> capabilities = getFirefoxDesiredCapabilities();
            case "opera" -> capabilities = getOperaDesiredCapabilities();
            default -> capabilities = getChromeDesiredCapabilities();
        }
        return capabilities;
    }
}
