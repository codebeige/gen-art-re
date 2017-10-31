(ns gen-art-re.style
  (:require [garden.core :as garden]
            [garden.stylesheet :as stylesheet]
            [goog.style])
  (:import [goog.html SafeStyleSheet]
           [goog.string Const]))

(defn css [& rules]
  (apply garden/css {:pretty-print? false} rules))

(defn install [& rules]
  (->> rules
       (apply css)
       Const.from
       SafeStyleSheet.fromConstant
       goog.style/installSafeStyleSheet))

(def breakpoints
  {:default "768px"
   :desktop "1024px"
   :desktop-hd "1440px"})

(defn size [size & rules]
  (when-let [s (size breakpoints)]
    (stylesheet/at-media {:min-width s} [:& rules])))
