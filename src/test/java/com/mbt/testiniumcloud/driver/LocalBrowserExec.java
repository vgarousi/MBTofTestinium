package com.mbt.testiniumcloud.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import java.util.*;

public class LocalBrowserExec {

    private static final Logger logger = LogManager.getLogger(LocalBrowserExec.class);

    public static WebDriver LocalExec(String browser) throws Exception{

        //SetBrowserForOS.setDriverPath(browser);

        WebDriver driver;
        switch (browser.toLowerCase(Locale.ENGLISH)){

            case "chrome" :
                driver = getChromeDriver();
                if(Boolean.parseBoolean(Driver.ConfigurationProp.getString("chromeZoomActive"))
                        && Driver.ConfigurationProp.getString("chromeZoomPlatform").contains(Driver.osName)) {
                    driver.get("chrome://settings/");
                    Thread.sleep(1000);
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("chrome.settingsPrivate.setDefaultZoom("
                            + Driver.ConfigurationProp.getString("chromeZoomSize") + ");");
                    Driver.chromeZoomCondition = true;
                }
                break;
            case "firefox" :
                driver = getFirefoxDriver();
                break;
            case "safari" :
                driver = getSafariDriver();
                break;
            case "edge" :
                driver = getEdgeDriver();
                break;
            default:
                throw new Exception("Hata");
        }

        if(Driver.isFullScreen) {
            Thread.sleep(1000);
           // driver.manage().window().fullscreen();
            driver.manage().window().maximize();

        }else if(Driver.ConfigurationProp.getString("setSize").equalsIgnoreCase("true")){
            String[] sizeValue = Driver.ConfigurationProp.getString("setSizeValue").split(",");
            Thread.sleep(1000);
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(Integer.parseInt(sizeValue[0]), Integer.parseInt(sizeValue[1])));
        }
        logger.info(((RemoteWebDriver) driver).getCapabilities().toString());
        return driver;
    }

    private static ChromeDriver getChromeDriver(){

       // DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities
       /** Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);*/
        //prefs.put("profile.default_content_setting_values.cookies", 2);
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addArguments("--lang=en-GB");
        //chromeOptions.addArguments("intl.accept_languages","en,en_US");
        //chromeOptions.setExperimentalOption("prefs", prefs);
        /**
         * Timed out receiving message from renderer hatası çözümü NONE
         * chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
         */
        //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);

        if (Driver.ConfigurationProp.getString("remoteDebuggingPort").equals("true")) {
            chromeOptions.addArguments("--remote-debugging-port=9222");
        }

        chromeOptions.addArguments("--disable-notifications");
        //chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-blink-features");
        chromeOptions.addArguments("--disable-blink-features=AutomationControlled");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.addArguments("disable-plugins");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.addArguments("ignore-certificate-errors");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("disable-extensions");
        chromeOptions.addArguments("--start-fullscreen");
        chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
       // chromeOptions.addArguments("--disable-web-security");
       // chromeOptions.addArguments("--no-proxy-server");
        //chromeOptions.addArguments("--allow-running-insecure-content");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
       // prefs.put("intl.accept_languages","en-GB");
        chromeOptions.setExperimentalOption("prefs", prefs);
        //chromeOptions.addArguments("--disable-blink-features=BlockCredentialedSubresources");
        // chromeOptions.addArguments("--incognito");
        // chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.setExperimentalOption("w3c",false);
        //chromeOptions.addArguments("--kiosk");
        //chromeOptions.addArguments("--disable-local-storage");
       // chromeOptions.addArguments("--disable-automation");
        //chromeOptions.setExperimentalOption("useAutomationExtension", false);
        //chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation" , "load-extension"));
        //chromeOptions.addArguments("disable-extensions");
        //chromeOptions.addArguments("--test-type");
        //chromeOptions.addArguments("--incognito");
        //chromeOptions.addArguments("--disable-gpu");
        //chromeOptions.addArguments("--headless");
        //chromeOptions.addArguments("window-size=800,600");
        //chromeOptions.setExperimentalOption("profile.default_content_setting_values.cookies", "2");
       // chromeOptions.addArguments("--start-maximized");
       // chromeOptions.addArguments("--start-fullscreen");
        // options
        setProxy(capabilities);
        chromeOptions.merge(capabilities);
        return new ChromeDriver(chromeOptions);
    }

    private static FirefoxDriver getFirefoxDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
       // DesiredCapabilities capabilities = new DesiredCapabilities().firefox();
       // capabilities.setCapability("marionette",true);
       // capabilities.setCapability("browser.privatebrowsing.autostart", true);
        //capabilities
       // ProfilesIni profile = new ProfilesIni();
        //FirefoxProfile testprofile = profile.getProfile("default");
        //capabilities.setCapability(FirefoxDriver.PROFILE, testprofile);
       /** FirefoxProfile ffprofile = new FirefoxProfile();
        ffprofile.setPreference("dom.webnotifications.enabled", false);*/
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        if(Boolean.parseBoolean(Driver.ConfigurationProp.getString("firefoxZoomActive"))
        && Driver.ConfigurationProp.getString("firefoxZoomPlatform").contains(Driver.osName)) {
            firefoxProfile.setPreference("layout.css.devPixelsPerPx",
                    Driver.ConfigurationProp.getString("firefoxZoomSize"));
            Driver.firefoxZoomCondition = true;
        }
       // firefoxProfile.setPreference("network.cookie.cookieBehavior",2);
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        firefoxOptions.setProfile(firefoxProfile);
        // firefoxProfile.setPreference("dom.disable_beforeunload", true);
        // firefoxProfile.setPreference("dom.push.enabled", false);
        //firefoxOptions.setProfile(new FirefoxProfile());
        //firefoxOptions.addArguments("-private");
        //firefoxOptions.addPreference("dom.push.enabled", false);
        //firefoxOptions.addPreference("dom.webnotifications.enabled", false);
       // firefoxOptions.addPreference("dom.disable_beforeunload", true);
        //firefoxOptions.addPreference("browser.privatebrowsing.autostart", true);
        //firefoxOptions.setLogLevel(FirefoxDriverLogLevel.INFO);
        // options
       /** FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        firefoxProfile.setPreference("dom.push.enabled", false);
        firefoxProfile.setPreference("dom.disable_beforeunload", true);
        firefoxProfile.setPreference("extensions.firebug.onByDefault", true);
        firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
        //firefoxProfile.setPreference("browser.startup.homepage", "https://www.google.com/tr");*/
        setProxy(capabilities);
        firefoxOptions.merge(capabilities);
        return new FirefoxDriver(firefoxOptions);
    }

    private static SafariDriver getSafariDriver(){

       // DesiredCapabilities capabilities = new DesiredCapabilities().safari();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities
        //capabilities.setCapability("browserstack.safari.enablePopups", "false");
        SafariOptions safariOptions = new SafariOptions();
        //safariOptions.setCapability("safari.cleanSession", true);
        //safariOptions.setUseTechnologyPreview(true);
        // options
        setProxy(capabilities);
        safariOptions.merge(capabilities);
        return new SafariDriver(safariOptions);
    }

    private static EdgeDriver getEdgeDriver(){

        DesiredCapabilities capabilities = new DesiredCapabilities();
        EdgeOptions edgeOptions = new EdgeOptions();

        //edgeOptions.setCapability("--ignore-certificate-errors", true);
        //edgeOptions.setCapability("disable-gpu", true);
        //edgeOptions.setCapability("disable-plugins", true);
        //edgeOptions.setCapability("--disable-notifications", true);
       // edgeOptions.setCapability("--start-fullscreen",true);
        Map<String, Object> map = new HashMap<>();
        List<String> args = Arrays.asList("--start-fullscreen","--disable-blink-features=AutomationControlled"
                //,"-inprivate"
                ,"--ignore-certificate-errors");
        map.put("args", args);
        edgeOptions.setCapability("ms:edgeOptions", map);
        // options
        setProxy(capabilities);
        edgeOptions.merge(capabilities);
        return new EdgeDriver(edgeOptions);
    }

    private static void setProxy(DesiredCapabilities capabilities){

        if(Driver.ConfigurationProp.getString("localProxyActive").trim().equals("true")) {
            String PROXY = Driver.ConfigurationProp.getString("localProxyAddress").trim();
            Proxy proxy = new Proxy();
            proxy.setProxyType(Proxy.ProxyType.MANUAL);
            proxy.setHttpProxy(PROXY);
            proxy.setFtpProxy(PROXY);
            proxy.setSslProxy(PROXY);
            capabilities.setCapability(CapabilityType.PROXY, proxy);
        }
    }

}
