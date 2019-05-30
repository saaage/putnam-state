(ns shared-state.rf-login.events
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
  :login
  (fn [db [_ new-user]]
    (println "db: " db "\n\n"
             "new-user: " new-user
             "returning new db value: " (merge db {:user new-user}))
    (merge db {:user new-user})))
