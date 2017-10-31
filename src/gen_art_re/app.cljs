(ns gen-art-re.app
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [gen-art-re.events]
            [gen-art-re.subs]
            [gen-art-re.views.layout :as layout]))

(defn root []
  (.getElementById js/document "app"))

(defn mount []
  (re-frame/clear-subscription-cache!)
  (reagent/render [layout/app] (root)))

(defn init []
  (re-frame/dispatch-sync [:init-db])
  (mount))
