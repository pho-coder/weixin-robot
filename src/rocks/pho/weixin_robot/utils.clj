(ns rocks.pho.weixin-robot.utils
  (:require [clj-webdriver.taxi :as taxi]))

(defn get-a-browser
  []
  (taxi/set-driver! {:browser :firefox}))

(defn go-to
  []
  (taxi/to "https://wx.qq.com"))
