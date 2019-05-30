(ns shared-state.components.context-providers.user-context-provider
  (:require ["react" :rename {createContext create-context
                              useReducer    use-reducer}]
            [hx.react :refer [defnc]]))

;;;; Create a user-context Provider component

;; 1. Default context value (optional)
(def default-user-context
  {:username   "guest"
   :privileges 0})

;; 2. Create a context
(def user-context (create-context default-user-context))

;; 3. Create an updater function (optional) 
;; Updater functions are only needed in cases where context needs to be writeable as well as readable   
(defn update-user-context
  [current m]
  (case (:type m)
    "LOGIN" {:username   (:username m)
             :privileges (:privileges m)}
    "LOGOUT" default-user-context

    (do (js/console.warn "Invalid action type passed to update-user-context") default-user-context)))

;; 4. Create the Provider component 
;; user-context-provider returns React component that we can place anywhere in the component tree, and its' descendants can consume all/some of the
;; context they want.
(defnc user-context-provider
  [m]
  "A component that provides descendants with the current user context."
  (let [[context set-context] (use-reducer update-user-context default-user-context)]
    [:provider {:context user-context
                :value   (merge context
                                {:update-user-context set-context})}
     (:children m)]))

;; NOTE: Steps 2 and 4 contain everything needed to create context for a tree of components

;; This pattern also provides the ability to have entire component trees that do not contain context if they don't need
;; it. eg. sections of the app that don't require a user to be logged in.
