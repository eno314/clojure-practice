(defproject clojure-practice "0.1.0-SNAPSHOT"
  :description "pracetice Clojure"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.12.0"]
                 [org.clojure/tools.namespace "1.4.4"]
                 [criterium "0.4.6"]]
  :dev-dependencies [[org.clojure/test.check "1.1.1"]
                     [pjstadig/humane-test-output "0.11.0"]]
  :plugins [[lein-cloverage "1.2.4"]
            [lein-cljfmt "0.8.0"]]
  :main clojure-practice.core
  :repl-options {:init-ns clojure-practice.core}
  :test-selectors {:default (complement :integration)
                   :integration :integration
                   :all (constantly true)})
