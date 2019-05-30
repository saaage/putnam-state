(ns shared-state.app
  (:require [hx.react :as hx]
            [shared-state.components.root :refer [root]]
            ["react-dom" :as react-dom]))

(defn app-render [component]
  "Takes a component and calls react-dom/render."
  (react-dom/render
    (hx/f [component])
    (. js/document getElementById "app")))

(defn ^:dev/after-load init []
  (app-render root))

