(ns shared-state.rf-login.views
  (:require [hx.react :refer [defnc]]
            [re-frame.core :as rf]))

(defnc rf-login
  []
  [:button {:on-click #(rf/dispatch-sync [:login {:username   "John Administrator"
                                            :privileges 10}])} 
   "login"])

(defnc rf-reset
  []
  [:button {:style {:margin-left "16px"
                    :margin-bottom "16px"}} "reset"])
