(ns shared-state.rf-greet-user.views
  (:require [re-frame.core :as rf]
            [hx.react :refer [defnc]]))

(defnc rf-greet-user
  []
  (let [user @(rf/subscribe [:user])]
    [:p "Hello, " (:username user) "!"]))

(defnc rf-user-stats
  []
  (let [user @(rf/subscribe [:user])]
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
