# Re-frame 101

Re-frame [docs](https://purelyfunctional.tv/guide/state-in-re-frame/#caching) recommend using the app-db for two specific use cases. Recommends adding in other methods such as **browser local storage** and **local component state** depending on use case.

1. state used by multiple components in the same browser tab
2. state that is cached from the server or third party APIs (eg a user’s shopping cart)

# Context 101 - [link](https://reactjs.org/docs/context.html#when-to-use-context)

Provides a way to share state that is considered to be global to a tree of React components. Recommended for high level contextual information such as:

* current concept/location
* current user
* browser locale information
* theming (eg. dark mode)


# Putnam has the following state use cases

* caching database responses from graphql queries to speed up load times (handled by apollo *for free*, **use case \#2** above)
  * apollo utilizes local storage to cache server reponses, and automatically updates cached values to prevent stale data
* state shared between components 
  * react provides a **primitive**, context, to handle state used by multiple components; re-frame **use case \#1** above
  * eg which concept/locations am I in? who is the current user?
* simple UI state such as a menu being expanded or collapsed
  * [re-frame](https://purelyfunctional.tv/guide/state-in-re-frame/#caching), [reagent](http://reagent-project.github.io/docs/master/WhenDoComponentsUpdate.html) as well as react ([1](https://medium.com/@dan_abramov/you-might-not-need-redux-be46360cf367), [2](https://spin.atomicobject.com/2017/06/07/react-state-vs-redux-state/), [3](http://https://stackoverflow.com/questions/41584647/when-do-i-choose-react-state-vs-redux-store)) all recommend preferring local component state ***before*** moving to other methods. React provides a **primitive** for local state, hooks.

# When/why to use **context** for re-frame use case #1? (since use case \#2 handled by Apollo)

* when state is consumed by multiple components
* significantly less boiler plate than re-frame/redux => lowers development time
* React devs that we hire will very likely be familiar with Context, they may not know re-frame's API yet
* fast/easy to learn:
  * Create context provider, a way to update context values (optional), consume context from any component.
  * VS the [6 domino](https://github.com/Day8/re-frame/blob/master/README.md) mental mode needed to understand how to use re-frame
* context is a core part of React’s API so we get state optimizations made by React team for free

# When to use **re-frame** over **context**?
* managing _high frequency_ (several times per second) global state updates **that are consumed by 100's of components**
  * [Dan Abramov from React core team defines "high frequency"](https://github.com/facebook/react/issues/14110#issuecomment-458753958) 
* global state transitions are rapid/complex, and there is a need for high powered dev tools and time travel debugging (eg re-frame-10x)
  * re-frame-10x allows devs to step through complex action history and data changes, viewing the app in the context of each
  
  
# Conclusion
## Rely on defaults that prefer less complexity, and when moving away from defaults pick the best tool based on the use case.
* React apps should **prefer local state** until global state is needed
* When global state is needed, React apps should **prefer context** until a event/dispatch/subscribe + debug pattern like re-frame/redux is needed
* When a high powered event/dispatch/subscribe pattern is needed, we should **prefer re-frame**
* Each solution can and _should_ be used side by side in a single application

### additional links
[you might not need redux, Dan Abramov](https://medium.com/@dan_abramov/you-might-not-need-redux-be46360cf367)
[application structure for larger re-frame apps](https://github.com/Day8/re-frame/blob/master/docs/Basic-App-Structure.md#larger-apps)
[redux comparison](https://www.learnreframe.com/)
[todomvc example](https://github.com/Day8/re-frame/tree/master/examples/todomvc)
[simple re-frame example](https://github.com/Day8/re-frame/blob/master/examples/simple/project.clj)
