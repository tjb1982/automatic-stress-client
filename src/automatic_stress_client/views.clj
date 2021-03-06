(ns automatic-stress-client.views
  (:require [hiccup.core :refer [html]]
            [hiccup.page :refer [include-js include-css]]
  ))

(defn index
  [& [properties]]
  (html
    [:html
      [:head
        [:title "Automated Cassandra Stress Test"]
        (include-css "/css/styles.css")]
      [:body
        [:form#keyspace-form
          [:label "Enter the keyspace where the test data was recorded:"]
          [:input#keyspace {:type "text" :name "keyspace"}]
          [:input {:type "submit"}]]
        [:a#show-properties {:href "javascript:void(0);"} "Toggle properties form"]
        [:form#properties-form
          [:label "Use this form to enter the desired properties and run the test again"]
          [:input {:type "submit" :value "Run another test with this configuration"}]
          [:textarea {:name "properties"} properties]]
        [:div#iterations]
        [:div#chart-container]
        (include-js "https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js")
        (include-js "/js/canvasjs.min.js")
        (include-js "/js/hoquet.js")
        (include-js "/js/main.js")
        ]]
    ))
