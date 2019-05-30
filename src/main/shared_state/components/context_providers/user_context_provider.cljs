(ns shared-state.components.context-providers.user-context-provider
  (:require ["react" :rename {createContext create-context
                              useReducer    use-reducer}]
            [hx.react :refer [defnc]]))

(def default-user-context
  {:username   "guest"
   :privileges 0})

(def user-context (create-context default-user-context))

(defn update-user-context
  [current m]
  (case (:type m)
    "LOGIN" {:username   (:username m)
             :privileges (:privileges m)}
    "LOGOUT" default-user-context

    (js/console.warn "Invalid call to update-user-context")))

(defnc user-context-provider
  [m]
  "A component that provides descendants with the current user context."
  (let [[context set-context] (use-reducer update-user-context default-user-context)]
    [:provider {:context user-context
                :value   (merge context
                                {:update-user-context set-context})}
     (:children m)]))

