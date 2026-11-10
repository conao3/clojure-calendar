(ns user
  (:require
   [clojure.tools.namespace.repl :as tools.namespace.repl]
   [calendar.system :as c.system]))

(alter-var-root #'*warn-on-reflection* (constantly true))

(def system (atom nil))

(defn init []
  (reset! system c.system/system))

(defn start []
  (swap! system c.system/start))

(defn stop []
  (when @system
    (swap! system c.system/stop)))

(defn go []
  (init)
  (start))

(defn reset []
  (stop)
  (tools.namespace.repl/refresh :after 'user/go))
