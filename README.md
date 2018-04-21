# Guava Rate Limiter

[![BuildStatus](https://travis-ci.org/revinate/guava-rate-limiter.svg?branch=master)](https://travis-ci.org/revinate/guava-rate-limiter)
[![BuildStatus](https://maven-badges.herokuapp.com/maven-central/com.revinate/guava-rate-limiter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.revinate/guava-rate-limiter)
[![codecov.io](https://codecov.io/github/revinate/guava-rate-limiter/coverage.svg?branch=master)](https://codecov.io/github/revinate/guava-rate-limiter?branch=master)

This is the rate limiter implementation found in the [Guava libraries](https://github.com/google/guava), extracted into
its own project so that modifications could be made. The main modification made in this version of the rate limiter is
the ability to set the max-burst-seconds property on the `SmoothBursty` rate limiter.

## Requirements

Java 1.6 and later.

## Installation

### Maven

Add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.revinate</groupId>
  <artifactId>guava-rate-limiter</artifactId>
  <version>19.1</version>
</dependency>
```

### Gradle

Add this dependency to your project's build script:

```groovy
compile 'com.revinate:guava-rate-limiter:19.1'
```
