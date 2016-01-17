
(ns cljs-time.dce-compile-test
  (:require
   [cljs-time.core :as time]))

(.log js/console (time/period-fns :weeks))
