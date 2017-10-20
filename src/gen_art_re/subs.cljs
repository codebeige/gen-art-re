(ns gen-art-re.subs
  (:require-macros [reagent.ratom :refer [reaction]])
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :title
 (fn [db]
   (:title db)))
