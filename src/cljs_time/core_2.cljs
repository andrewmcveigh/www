
(ns cljs-time.core-2
  (:require
   [clojure.string :as string])
  (:import
   [goog.date Interval]))

(def period-fns
  {:millis (fn [date op value]
             (let [ms (op (.getTime date) value)]
               (doto date (.setTime ms))))
   :weeks  (fn [date op value]
             (let [days (op 0 (* value 7))]
               (doto date
                 (.add (Interval. Interval.DAYS days)))))})

(def periods
  {:seconds Interval.SECONDS
   :minutes Interval.MINUTES
   :hours   Interval.HOURS
   :days    Interval.DAYS
   :months  Interval.MONTHS
   :years   Interval.YEARS})
