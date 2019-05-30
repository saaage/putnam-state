(ns shared-state.components.root
  (:require [hx.react :as hx :refer [defnc]]
            [shared-state.components.context-providers.user-context-provider :refer [user-context-provider]]
            [shared-state.components.greet-user :refer [greet-user]]
            [shared-state.components.user-stats :refer [user-stats]]
            [shared-state.components.login :refer [login reset]]
            ["react" :rename {useContext use-context}]))

(defnc root
  []
  "Our application's root component. Contains all of our providers."
  [:div {:style {:display "flex"
                 :height  "100vh"}}

   [:div {:style {:flex    1
                  :border  "2px dashed green"
                  :padding "8px"}} 
    [user-context-provider
     [:h2 "React Context"]
     [login]
     [reset]
     [:h4  "The components below are totally separate from each other but read values they care about from the current user context."]
     [:h5 "Component 1:"]
     [greet-user]
     [:h5 "Component 2:"] 
     [user-stats]]]

   [:div {:style {:flex 1
                  :border  "2px dashed blue"
                  :padding "8px"}}
    [:h2 "Re-frame"]]])

