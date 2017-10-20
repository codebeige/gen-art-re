(ns gen-art-re.events
  (:require [re-frame.core :as re-frame]
            [gen-art-re.db :as db]))

(re-frame/reg-event-db
 :init-db
 (fn  [_ _]
   db/default-db))
