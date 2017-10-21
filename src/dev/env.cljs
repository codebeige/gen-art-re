(ns dev.env
  (:require [devtools.core :as devtools]))

(enable-console-print!)
(devtools/install!)

(println "Development environment loaded.")
