(ns shared-state.components.root
  (:require [hx.react :as hx :refer [defnc]]
            [shared-state.components.context-providers.user-context-provider :refer [user-context-provider]]
            [shared-state.components.greet-user :refer [greet-user]]
            [shared-state.components.user-stats :refer [user-stats]]
            [shared-state.components.login :refer [login]]
            ["react" :rename {useContext use-context}]))

(defnc root
  []
  "Our application's root component. Contains all of our providers."
  [:div {:style {:display "flex"
                 :height  "100vh"}}
   [:div {:style {:flex    1
                  :border  "2px dashed green"
                  :padding "8px"}} 
    [:h2 "React Context"]
    [user-context-provider
     [greet-user]
     [login]
     [user-stats]]]
   [:div {:style {:flex 1
                  :border  "2px dashed blue"
                  :padding "8px"}}
    [:h2 "Re-frame"]]])

