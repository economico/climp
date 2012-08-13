(ns climp.core
  (:require [clj-http.client :as client])
  (:use [cheshire.core]))

(def ^:dynamic *mc-api-key*
  (let [env (System/getenv)]
    (get env "MC_API_KEY" (get env "MAILCHIMP_API_KEY"))))

(defn mailchimp-dc
  "Return the MailChimp Datacenter for API KEY"
  []
  (if *mc-api-key*
    (last (re-find #"-(\w+)$" *mc-api-key*))
    "us1"))

(defn mailchimp-url
  "Return the base url for a MailChimp API call. This is determined by your api key"
  []
  (str "https://" (mailchimp-dc) ".api.mailchimp.com/1.3/"))

(defn method-url
  "URL for calling a method"
  [method]
  (str (mailchimp-url) "?method=" method))

(defn call-mailchimp
  "Call a method on MailChimp"
  [method params]
  (:body (client/post (method-url method) {
    :as :json
    :content-type :json
    :body (generate-string (assoc params :apikey *mc-api-key*))
    })))

(defn lists
  "return lists"
  []
  (:data (call-mailchimp "lists" {})))

(defn subscribe
  "Subscribe an email address to the given mailing list.

  The list is the id as returned by (lists)."
  [list email]
  (call-mailchimp "listSubscribe" {:id list :email_address email}))