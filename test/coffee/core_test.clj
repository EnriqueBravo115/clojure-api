(ns coffee.core-test
  (:require [clojure.test :refer :all]
            [coffee.core :refer :all]))

(defn add [x y]
  (+ x y))

(deftest test-functions
  (testing "add"
    (is (= 5 (add 3 2)))
    (is (= 0 (add -3 3)))))
