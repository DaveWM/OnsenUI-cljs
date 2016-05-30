(ns onsenui-test.app
  (:require [reagent.core :as r]))

(enable-console-print!)

                                        ; I've put all the reagent code in an onload handler, so the onsenui scripts load first.
                                        ; Alternatively, you can load react from a script tag, and exclude it from the reagent dependency in project.clj
(set! (.-onload js/window)
      (fn []
        (def react-container (.-body js/document))

        (def onsen-button (r/adapt-react-class (-> js/window
                                                   .-Ons
                                                   .-Button)))

        (defn main-component []
          "The root component for the app"
          [:div
           [onsen-button {:modifier "material"
                          :onClick #(js/alert "Clicked!")}
            "OnsenUI Button"]])

        (r/render-component [main-component] react-container)))
