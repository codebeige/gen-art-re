(ns gen-art-re.views
  (:require [re-frame.core :as re-frame]))

(defn app []
  (let [title (re-frame/subscribe [:title])]
    (fn []
      [:h1 @title])))
