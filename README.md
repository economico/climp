# Climp

A simple Clojure library wrapper for MailChimp

[![Build Status](https://secure.travis-ci.org/economico/climp.png)](http://travis-ci.org/economico/climp)

## Usage

Add the following to your project.clj's dependencies section:

```clojure
[climp "0.1.2"]
```

Import the library:

```clojure
(use 'climp.core)
```

You can call any method listed in the [MailChimp V1.3 API](http://apidocs.mailchimp.com/api/1.3/)

```clojure
(call-mailchimp "listSubscribe" {:id "123" :email_address "test@test.com"})
```

A few of the methods have nicer clojure wrappers around them. I hope to expand this as we go.

```clojure
(lists) ; Returns your mailing lists
```

Subscribe an email address:

```clojure
(subscribe "123" "test@test.com")
```

## Configuring API Keys

The easiest way to set it up is to set your api key in the MC_API_KEY environment variable or system property.

Alternatively you can create a dynamic binding for *mc-api-key*.

## Use Mandrill?

We also maintain a simple clojure library [clj-mandrill](https://github.com/economico/clj-mandrill) for interacting with Mandrill.

## License

Copyright © 2012 PicoMoney Company

Manage and track your startups economy using our new service [Economi.co](http://economi.co).

Distributed under the Eclipse Public License, the same as Clojure.
