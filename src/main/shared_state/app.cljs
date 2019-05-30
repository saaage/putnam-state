(ns shared-state.app
  (:require [hx.react :as hx]
            [shared-state.components.root :refer [root]]
            [shared-state.rf-greet-user.events]
            [shared-state.rf-login.events]
            [shared-state.rf-greet-user.subs]
            [re-frame.core :as rf]
            ["react-dom" :as react-dom]))

(defn app-render [component]
  "Takes a component and calls react-dom/render."
  (react-dom/render
    (hx/f [component])
    (. js/document getElementById "app")))


(defn ^:dev/after-load init []
  (rf/dispatch-sync [:initialize-user-db])
  (app-render root))

