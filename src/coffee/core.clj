(ns coffee.core
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.http :as http])
  (:gen-class))

(defn function-hello [request]
  {:status 200 :body "Hello world"})

(def routes (route/expand-routes #{["/hello" :get function-hello :route-name :hello-world]}))

(def      service-map {::http/routes routes
                  ::http/port 9999
                  ::http/type :jetty
                  ::http/join? false})

(println "Started Server")

(defn -main
  [& args]
  (http/start (http/create-server service-map)))
