(ns shared-state.rf-greet-user.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :user
  (fn [db _]
    (:user db)))

