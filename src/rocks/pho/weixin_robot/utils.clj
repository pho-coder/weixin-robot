(ns rocks.pho.weixin-robot.utils
  (:require [clojure.java.io :as io]
            [postal.core :refer [send-message]])
  (:import [org.openqa.selenium WebDriver OutputType]
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
  (let [file (.getScreenshotAs @*driver* OutputType/FILE)]
    (io/copy file (io/file "/tmp/a.png"))
    file))

(defn send-mail
  [host from-email to-email user password file]
  (let [re (send-message {:host host
                          :ssl true
                          :user user
                          :pass password}
                         {:from from-email
                          :to to-email
                          :subject "weixin login"
                          :body [{:type :attachment
                                  :content file}]})]
    re))
