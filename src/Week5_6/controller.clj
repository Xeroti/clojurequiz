(ns Week5-6.controller
  (:use [noir.core :only [defpartial]]
        [hiccup.page :only [include-css html5 include-js]]))

(defpartial layout [& content]
  (html5
    [:head
     [:title "Quiz"]
     (include-css "style.css") content]))