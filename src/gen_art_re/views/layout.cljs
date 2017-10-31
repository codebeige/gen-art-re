(ns gen-art-re.views.layout
  (:require [garden.stylesheet :refer [at-media]]
            [gen-art-re.style :as style]))

(defonce style
  (style/install
   [:header {:position "fixed"
             :top "0px"
             :left "0px"
             :width "100%"
             :max-width "1200px"
             :padding {:top "1.5em"
                       :bottom "0.75em"
                       :left "1.5rem"
                       :right "0.75rem"}}
    (style/size :default
                {:padding {:top "3em"
                           :left "2rem"
                           :right "3rem"}})
    (style/size :desktop-hd
                {:left "3vw"})
    [:h1 {:font-size "2rem"
          :margin 0}]]))

(defn header []
  [:header [:h1 "GenArt RE"]])

(defn main []
  [:main])

(defn app []
  [:div
   [header]
   [main]])
