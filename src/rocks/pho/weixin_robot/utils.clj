(ns rocks.pho.weixin-robot.utils
  (:import [org.openqa.selenium WebDriver]
           [org.openqa.selenium.chrome ChromeDriverService ChromeDriverService$Builder]
           [org.openqa.selenium.remote DesiredCapabilities RemoteWebDriver]))

(def ^:dynamic *driver* (atom nil))

(defn get-a-browser
  []
  (let [service (.build (.usingAnyFreePort (.usingDriverExecutable (ChromeDriverService$Builder.)
                                                                   (java.io.File. "/home/phoenix/bin/chromedriver"))))]
    (.start service)
    (let [capabilities (DesiredCapabilities/firefox)]
      (reset! *driver* (RemoteWebDriver. (.getUrl service)
                                         capabilities)))))

(defn go-to
  []
  (.get @*driver* "https://wx.qq.com"))

(defn get-screenshot
  []
  (.getScreenshotAs ))
