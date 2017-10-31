(ns gen-art-re.views.layout)

(defn header []
  [:header [:h1 "GenArt RE"]])

(defn main []
  [:main])

(defn app []
  [:div
   [header]
   [main]])
