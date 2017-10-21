(ns dev.env
  (:require [day8.re-frame.trace :as trace]
            [devtools.core :as devtools]))

(enable-console-print!)

(devtools/install!)

(trace/init-tracing!)
(trace/inject-devtools!)

(println "Development environment loaded.")
