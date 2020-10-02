

<!-- TABLE OF CONTENTS -->
## Table of Contents

* [About the Project](#about-the-project)
  * [Built With](#built-with)
  * [Prerequisites](#prerequisites)
* [Usage](#usage)
  * [Deploying](#deploying)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->
## About The Project

This template presents a scalable web server which can be deployed in less than five minutes. Each feature presented on the web page has been implemented as a seperate module using Kotlin/kotlinx.html as the primary template rendering engine. Additionally, this template is completely responsive, supporting devices of all sizes. This project is currently deployed as Heroku project hosted at [brettdowney.ca](www.template.brettdowney.ca).

### Built With

* [Kotlin](https://kotlinlang.org/)
* [Kotlin/kotlinx.html](https://github.com/Kotlin/kotlinx.html)
* [Ktor](https://ktor.io/)
* [TypeScript](https://www.typescriptlang.org/)
* [SCSS](https://sass-lang.com/)
* [Bootstrap](https://getbootstrap.com)
* [JQuery](https://jquery.com)
* [Gradle](https://gradle.org/)


### Prerequisites

* Java 8 or greater

## Usage
1. Clone the repo
2. Build using Gradle
3. Run using Gradle

### Deploying

Deploy the project to any Heroku application. A custom Gradle build has been included within ```gradle.build``` and will automatically deploy this project to a Heroku application.
```heroku push git master```
```heroku ps:scale web=1```
```heroku open```

<!-- CONTACT -->
## Contact

Brett Downey - brettdowneyeih@gmail.com
