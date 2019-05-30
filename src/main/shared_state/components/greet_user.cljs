(ns shared-state.components.greet-user
  (:require [hx.react :refer [defnc]] 
            [shared-state.components.context-providers.user-context-provider :refer [user-context]]
            ["react" :rename {useContext use-context}]))

;;;; Consume user-context to render a greeting to the current user

(defnc greet-user
  []
  (let [user (use-context user-context)]
    [:p "Hello, " (:username user) "!"]))
