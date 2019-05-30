(ns shared-state.components.login
  (:require [hx.react :refer [defnc]]
            [shared-state.components.context-providers.user-context-provider :refer [user-context]]
            ["react" :rename {useContext use-context}]))

(defnc login
  []
  (let [{:keys [update-user-context]} (use-context user-context)]
    [:button {:on-click #(update-user-context {:type       "LOGIN"
                                               :username   "John Administrator"
                                               :privileges 10})
              :style {:margin-left "16px"
                      :margin-bottom "16px"}} 
     "login"]))
