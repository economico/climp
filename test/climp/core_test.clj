(ns climp.core-test
  (:use clojure.test
        climp.core
        clj-http.fake
        cheshire.core))


(deftest url-api-keys
  (is (= "us1" (mailchimp-dc)))
  (is (= "https://us1.api.mailchimp.com/1.3/" (mailchimp-url)))

  (binding [ *mc-api-key* "abcdefg-us3" ]
    (is (= "us3" (mailchimp-dc)))
    (is (= "https://us3.api.mailchimp.com/1.3/" (mailchimp-url)))
    (is (= "https://us3.api.mailchimp.com/1.3/?method=listSubscribe" (method-url "listSubscribe")))
    (with-fake-routes
      { "https://us3.api.mailchimp.com/1.3/?method=listSubscribe"
        (fn [req] (let [ body (slurp (.getContent (:body req))) ]
                    {:status 200 :headers {"Content-type" "application/json"} :body body }))}

      (let [ resp (call-mailchimp "listSubscribe" {:email_address "bob@test.com"})]
            (is (= "abcdefg-us3" (:apikey resp)))
            (is (= "bob@test.com" (:email_address resp)))
        )
      )
  ))

