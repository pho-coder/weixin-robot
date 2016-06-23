(ns rocks.pho.weixin-robot.utils-test
  (:require [clojure.test :refer :all]
            [rocks.pho.weixin-robot.utils :refer :all]))

(deftest go-to-test
  (testing "FIXME, I fail."
    (let [a (get-a-browser)]
      (go-to))))

(defn go-to-a
  []
  (let [a (get-a-browser)]
    (go-to)))
