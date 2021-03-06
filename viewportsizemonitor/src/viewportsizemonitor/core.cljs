(ns viewportsizemonitor
  (:require
    [goog.dom :as dom]
    [goog.events :as goog-events]
    [goog.events.EventType :as event-type]
    [goog.math.Size :as math-size]
    [goog.style :as goog-style]
    [goog.dom.ViewportSizeMonitor :as viewport-size]))

(defn ^:export setup []
  (let [update-ui (fn [size]
                    (goog-style/setSize (dom/getElement "demo") size)
                    (dom/setTextContent (dom/getElement "current_size") (. size (toString))))
        vsm (goog.dom.ViewportSizeMonitor.)]
    (update-ui (dom/getViewportSize))
    (goog-events/listen vsm
                        event-type/RESIZE
                        (fn [e] (update-ui (. vsm (getSize)))))))
