(ns clara-example.core
  (:require [clara.rules :refer [defrule mk-session fire-rules insert]]))

(def a "a")

(defrule using-literals
  [?o <- "a"]
  =>
  (println (str "using-literals found an 'a' as " (:value ?o))))

(defrule using-variables
  [?o <- a]
  =>
  (println (str "using-variables found an 'a' as " (:value ?o))))

(-> (mk-session 'clara-example.core :fact-type-fn :type)
    (insert {:type "a" :value "literal"})
    (insert {:type a :value "variable"})
    fire-rules)
