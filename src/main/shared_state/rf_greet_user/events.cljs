(ns shared-state.rf-greet-user.events
  (:require [re-frame.core :as rf]
            [shared-state.rf-greet-user.db :refer [default-db]]))

(rf/reg-event-db
  :initialize-user-db
  (fn [_ _] 
    default-db))
