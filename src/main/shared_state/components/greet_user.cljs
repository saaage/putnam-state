(ns shared-state.components.greet-user
  (:require [hx.react :refer [defnc]] 
            [shared-state.components.context-providers.user-context-provider :refer [user-context]]
            ["react" :rename {useContext use-context}]))

(defnc greet-user
  []
  (let [user (use-context user-context)]
    [:p {:style {:min-width "180px"
                 :display "inline-block"}} "hello, " (:username user) "!"]))
