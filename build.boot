(set-env! :resource-paths #{"resources"}
          :source-paths   #{"src"}
          :dependencies   '[[org.clojure/clojurescript "1.9.946"]
                            [org.clojure/clojure "1.9.0-beta3" :scope "test"]

                            [re-frame "0.10.2"]
                            [reagent  "0.8.0-alpha2"]

                            [adzerk/boot-cljs        "2.1.4"  :scope "test"]
                            [adzerk/boot-cljs-repl   "0.3.3"  :scope "test"]
                            [adzerk/boot-reload      "0.5.2"  :scope "test"]
                            [binaryage/devtools      "0.9.7"  :scope "test"]
                            [com.cemerick/piggieback "0.2.2"  :scope "test"]
                            [day8.re-frame/trace     "0.1.11" :scope "test"]
                            [org.clojure/tools.nrepl "0.2.13" :scope "test"]
                            [pandeiro/boot-http      "0.8.3"  :scope "test"]
                            [weasel                  "0.7.0"  :scope "test"]]
          :exclusions     '[org.clojure/clojure
                            org.clojure/clojurescript])

(require
 '[adzerk.boot-cljs      :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl]]
 '[adzerk.boot-reload    :refer [reload]]
 '[pandeiro.boot-http    :refer [serve]])

(deftask dev
  "Start up interactive development environment."
  []
  (comp
   (serve)
   (watch)
   (cljs-repl)
   (reload :on-jsload 'gen-art-re.app/mount)
   (cljs :optimizations :none
         :compiler-options {:preloads '[dev.env]
                            :closure-defines '{re-frame.trace.trace-enabled? true}})))

(deftask build
  "Create a production build."
  []
  (comp
   (cljs :optimizations :advanced)
   (sift :include #{#"\.edn$" #"\.out/"} :invert true)
   (target :dir #{"build"})))
