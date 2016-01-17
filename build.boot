
(set-env!
 :source-paths #{"src"}
 :dependencies '[[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.228"]])

(require '[cljs.build.api :as cljs])
(require '[cljs.closure :as closure])
(require '[clojure.java.io :as io])

(defn compile-size [namespace]
  (let [uri (:uri (closure/cljs-source-for-namespace namespace))
        outfile "target/dce-test"
        js (cljs/build uri
                       {:cache-analysis true
                        :main namespace
                        :output-to outfile
                        :optimizations :advanced
                        :pseudo-names true
                        :pretty-print true})
        length (.length (io/file outfile))]
    (println (format "%.2fK" (double (/ length 1024))))))

;; (compile-size 'cljs-time.core)
