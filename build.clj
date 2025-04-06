(ns build
  (:require
   [clojure.tools.build.api :as b]))

(def lib 'calendar/core)
(def libsym 'calendar.core)
(def version (format "0.1.%s" (b/git-count-revs nil)))
(def class-dir "target/classes")
(def basis (delay (b/create-basis {:project "deps.edn"})))

(defn jar [_]
  (b/write-pom {:class-dir class-dir
                :lib lib
                :version version
                :basis @basis
                :src-dirs ["src"]})
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/jar {:class-dir class-dir
          :jar-file (format "target/%s-%s.jar" (namespace lib) version)}))

(defn uber [_]
  (b/copy-dir {:src-dirs ["src" "resources"]
               :target-dir class-dir})
  (b/compile-clj {:basis @basis
                  :ns-compile [libsym]
                  :class-dir class-dir})
  (b/uber {:class-dir class-dir
           :uber-file (format "target/%s-%s-standalone.jar" (namespace lib) version)
           :basis @basis
           :main libsym}))
