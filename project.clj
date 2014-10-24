(defproject desafio "0.1.0-SNAPSHOT"
  :description "Desafio de estagio"
  :url "http://github.com/ma-te-us/desafio"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [aysylu/loom "0.5.0"]]
  :main ^:skip-aot desafio.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
  :resource-paths ["shared" "resources"]
