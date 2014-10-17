# About

This is the fancy html/js frontend for the demo. The user can see a **very** basic overview of information we got about its client. 

# Setup

## Prerequisites

* Install ```npm```. 
* You need also a ```sass``` interpreter. http://sass-lang.com/   

## Project setup

(You can skip some steps if you have the tool already installed...)

```
npm install -g grunt-cli
npm install -g bower
npm install
bower install
```

# Run

```
grunt serve
```

You will get problems because of the cross-origin-policy. To fix this start the google chrome browser with the ```--disable-web-security``` parameter. 


# ToDo

* must run on nexus4
* get ip request, prefill ip field
* Clear data if ip changes