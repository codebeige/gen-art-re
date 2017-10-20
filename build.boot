(set-env! :resource-paths #{"resources"}
          :source-paths   #{"src"}
          :dependencies   '[[org.clojure/clojurescript "1.9.946"]
                            [adzerk/boot-cljs    "2.1.4"       :scope "test"]
                            [org.clojure/clojure "1.9.0-beta2" :scope "test"]
                            [pandeiro/boot-http  "0.8.3"       :scope "test"]]
          :exclusions     '[org.clojure/clojure
                            org.clojure/clojurescript])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev
  "Start up interactive development environment."
  []
  (comp
   (serve)
   (watch)
   (cljs :optimizations :none
         :compiler-options {:preloads '[dev.env]})))

(deftask build
  "Create a production build."
  []
  (comp
   (cljs :optimizations :advanced)
   (sift :include #{#"\.edn$" #"\.out/"} :invert true)
   (target :dir #{"build"})))
