(ns usd-native.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [usd-native :as usd-native]))

(deftest constants-match-original-rust-values
  (testing "faithful 1:1 port of the Rust crate's constants"
    (is (= "ADR-2605261800" usd-native/adr))
    (is (= "R1.0-path-reservation" usd-native/phase))
    (is (= "kami-usd-native" usd-native/kami-name))
    (is (= "contingent-fallback-pending-viability-gate" usd-native/status))
    (is (= "tinyusdz WASM gate fail (R1.1)" usd-native/triggered-by))
    (is (= ["omni.usd" "pxr.Usd" "pxr.UsdGeom"] usd-native/nv-compat-targets))
    (is (= ["usda" "usdc" "usdz"] usd-native/supported-formats))))

(deftest smoke-test
  (testing "module loads and namespace values are non-nil"
    (is (some? usd-native/adr))
    (is (some? usd-native/kami-name))
    (is (vector? usd-native/nv-compat-targets))
    (is (vector? usd-native/supported-formats))
    (is (= 3 (count usd-native/nv-compat-targets)))
    (is (= 3 (count usd-native/supported-formats)))))
