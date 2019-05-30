(ns shared-state.components.user-stats
  (:require [hx.react :refer [defnc]] 
            [shared-state.components.context-providers.user-context-provider :refer [user-context]]
            ["react" :rename {useContext use-context}]))

(defnc user-stats
  []
  (let [user (use-context user-context)]
    [:table {:style {:border          "1px solid gray"
                     :border-collapse "collapse"}}
     [:tbody
      [:tr {:style {:border          "1px solid gray"
                    :border-collapse "collapse"}}
       [:th {:style {:border          "1px solid gray"
                     :border-collapse "collapse"}} "access level"]]
      [:tr {:style {:border          "1px solid gray"
                    :border-collapse "collapse"}}
       [:td {:style {:border          "1px solid gray"
                     :border-collapse "collapse"
                     :text-align      "right"}} (:privileges user)]]]]))
