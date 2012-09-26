# Climp

A simple Clojure library wrapper for MailChimp

[![Build Status](https://secure.travis-ci.org/economico/climp.png)](http://travis-ci.org/economico/climp)

## Usage

Add the following to your project.clj's dependencies section:

    [climp "0.1.1"]

Import the library:

    (use 'climp.core)

You can call any method listed in the (MailChimp V1.3 API)[http://apidocs.mailchimp.com/api/1.3/]

    (call-mailchimp "listSubscribe" {:id "123" :email_address "test@test.com"})

A few of the methods have nicer clojure wrappers around them. I hope to expand this as we go.

    (lists) ; Returns your mailing lists

Subscribe an email address:

    (subscribe "123" "test@test.com")

## Configuring API Keys

The easiest way to set it up is to set your api key in the MC_API_KEY environment variable or system property.

Alternatively you can create a dynamic binding for *mc-api-key*.

## License

Copyright © 2012 PicoMoney Company

Distributed under the Eclipse Public License, the same as Clojure.
