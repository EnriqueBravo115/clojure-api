(ns coffee.book
  (:require [io.pedestal.http.route :as route]
            [io.pedestal.http :as http]))

(defn function-hello [request]
  {:status 200 :body "Hello world"})

(def routes(route/expand-routes #{["/hello" :get function-hello :route-name :hello-world]}))

(def service-map {::http/routes routes
                  ::http/port 9999
                  ::http/type :jetty
                  ::http/join? false})

(http/start (http/create-server service-map))
