
(cljs-time.core/minus x (cljs-time.core/months 21))

(ns cljs-time.base-2
  (:require [cljs-time.core-1 :as time]))

(.log js/console (time/period-fns :weeks))
