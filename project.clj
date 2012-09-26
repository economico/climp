(defproject climp "0.1.2"
  :description "MailChimp wrapper for clojure WIP"
  :url "http://github.com/economico/mailchimp-clj"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                  [clj-http "0.5.2"]
                  [cheshire "4.0.1"]]
  :profiles {:dev {:dependencies [[clj-http-fake "0.4.1"]]}})
