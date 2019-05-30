(ns shared-state.components.user-stats
  (:require [hx.react :refer [defnc]] 
            [shared-state.components.context-providers.user-context-provider :refer [user-context]]
            ["react" :rename {useContext use-context}]))

;;;; Consume user-context to show information about the current user

(defnc user-stats
  []
  (let [user (use-context user-context)]
    [:table {:style {:border          "1px solid gray"
                     :border-collapse "collapse"}}
     [:tbody
      [:tr {:style {:border          "1px solid gray"
                    :border-collapse "collapse"}}
       [:th {:style {:border          "1px solid gray"
                     :border-collapse "collapse"}} "Access Level"]]
      [:tr {:style {:border          "1px solid gray"
                    :border-collapse "collapse"}}
       [:td {:style {:border          "1px solid gray"
                     :border-collapse "collapse"
                     :text-align      "right"}} [:b (:privileges user)]]]]]))
