# Grocery backend getting-started

A java application using springboot 2.5.2  
This is the backend API, frontend mobile version created with flutter at https://github.com/ramdanariadi/grocery-front-end
## Running Locally

* Installing docker  
  visit : <a href="https://docs.docker.com/engine/install" target="_blank">Install docker</a>
* Installing docker compose  
  visit : <a href="https://docs.docker.com/compose/install" target="_blank">Install docker compose</a>

* Run
```
    $ git clone https://github.com/ramdanariadi/grocery-be.git
    $ docker-compose up -d
    $ mvn clean install  
    $ mvn spring-boot:run
```
The application should now be running on localhost:8080

## Deploying to heroku

```
    $ heroku  login
    $ heroku create
    $ git push heroku master
```
or

<a href="https://devcenter.heroku.com/articles/deploying-java" target="_blank"><img src="https://www.herokucdn.com/deploy/button.svg"></a>

## Documentation

For more information about using java on heroku, see these Dev Center articles:
* <a href="https://devcenter.heroku.com/articles/getting-started-with-java" target="_blank">Getting started on Heroku with java</a>
* <a href="https://devcenter.heroku.com/articles/preparing-a-java-web-app-for-production-on-heroku" target="_blank">Preparing a Java Web App for Production on Heroku</a>
* <a href="https://devcenter.heroku.com/articles/java-support" target="_blank">Heroku java support</a>
