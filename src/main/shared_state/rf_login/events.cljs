(ns shared-state.rf-login.events
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
  :login
  (fn [db [_ new-user]]
    (assoc db :user new-user)))
