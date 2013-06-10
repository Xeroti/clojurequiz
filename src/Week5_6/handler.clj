(ns Week5-6.handler
  (:require [noir.server :as server]))

(server/load-views-ns 'Week5-6.view)

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "PORT" "3000"))]
    (server/start port {:mode mode
                        :ns 'Week5-6})))

