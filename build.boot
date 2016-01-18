
(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]])

(require '[cljs.build.api :as cljs])
(require '[cljs.closure :as closure])
(require '[clojure.java.io :as io])

(def compiled-file "target/compiled.min.js")

(def compiler-opts
  {:cache-analysis true
   :output-to compiled-file
   :optimizations :advanced})

(defn compile-size [namespace]
  (let [uri (:uri (closure/cljs-source-for-namespace namespace))
        all-compiler-opts (assoc compiler-opts :main namespace)
        js (cljs/build uri all-compiler-opts)
        length (.length (io/file compiled-file))]
    (println (format "%.2fK" (double (/ length 1024))))))
