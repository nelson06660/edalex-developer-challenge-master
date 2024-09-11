# Edalex Developer Challenge

## Overview

The challenge is to develop a *very* simple message board web app. It will consist of two parts:

* A [React](https://reactjs.org/) front-end written in [Typescript](https://www.typescriptlang.org/)
* A [Spring Boot](https://spring.io/projects/spring-boot) REST API back-end written in Java

Stubs have been provided for both of these (see 'Quick start'). The challenge is to build them
out to meet the below requirements. (Before starting, make sure you can successfully start the
server and client as detailed in the 'Quick start'.)

If you require additional assistance on Spring Boot, React or Typescript there are some helpful
links at the end of this README.

## Quick start

First, it is assumed you have the following items installed:

* JDK 17
* NodeJS / NPM
  * [Node Version Manager](https://github.com/nvm-sh/nvm) should be used to ensure you're on the
    correct version as specified in `client/.nvmrc`.

### Server

Go into the `server` folder and use the Gradle wrapper to make sure all is working. On Linux and
MacOS that will look like:

    ./gradlew bootRun

On Windows:

    gradlew.bat bootRun

You should see it download dependencies, build the source, and then complete a server start-up. At
which point you should be able to confirm all is working by going to
<http://localhost:8080/api/message>. That will return you a JSON response with three messages.

### Client

First, Go into the `client` folder and install the Node dependencies:

    npm ci

Then start the local dev server/build environment:

    npm start

After a few moments, you should be able to visit the client in your browser at:
<http://localhost:3000/>.

## Requirements

Your completed challenge must meet these requirements:

* Display a list of messages ordered with the most recent at the top
* Allow a user to add a message
* Allow a user to remove a message
* View a single message (i.e. a permalink)

### User Interface

It is acceptable to deliver a bare bones, plain HTML UI. However, you're invited to deliver one which
is done with [Material-UI](https://material-ui.com/).

### Data Persistence

It is acceptable to deliver with the system simply using a file (CSV, YAML, JSON, your own format)
for persisting the data (no expectation of ACID compliance). However, if you'd like to demonstrate
your ability to use an ORM, you're welcome to use a file based H2 set-up.

If you do go down the ORM path, either make sure that the configuration is embedded, or that you
provide additional documentation. But please stick to H2, we do not have time to spin up RDBs when
evaluating submissions.

### Security

We are not expecting any security to be implemented.

## What we're looking for

First and foremost, make sure you meet the requirements.

Assuming the requirements are met, we expect to see a simple, idiomatic React/TypeScript single-page
application. This should be backed by a straightforward Java REST service that demonstrates your
understanding of separation of concerns through well-defined application layers.

Expect that it will be run in current versions of both Chrome _and_ Firefox.

NOTE: Redux is not required for this challenge. It is acceptable to use Reacts built-in state
management. (Including reducers and context if desired.)

### Shine

If you'd really like to make your submission shine, consider doing one or more of the following:

* Demonstrate use of Material-UI for the client;
* Demonstrate use of an ORM for the persistence layer; 
* Include a suite of automated tests;
  * For example, jUnit or Spock for server with Jest / React Testing Library for client.
* And lastly, consider the presentation of your code - make it tidy, clean and professional.

## Submission

We expect to receive back the resultant source tree - without intermediate files (most of which are
excluded by `.gitignore`). We will then build the two parts and run them to ensure compliance with
requirements. Then we'll undertake a code review.

(Make sure any additional instructions are included. For example, if you've used an ORM, make sure
you've included the necessary configuration.)

## Some helpful resources

* [Spring Boot - Getting Started: Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Typescript in 5 minutes](https://www.typescriptlang.org/docs/handbook/typescript-in-5-minutes.html)
* [React tutorial](https://reactjs.org/tutorial/tutorial.html)
