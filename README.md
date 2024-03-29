# Проект автоматизации тестирования [Deeray.com](https://deeray.com/)
<a href="https://deeray.com/"><img width="100%" title="Deeray.com" src="media/screen/logo.png" alt="Deeray.com"></a>

## Содержание:

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#allure">Allure отчет</a>
* <a href="#allure-testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#telegram">Уведомление в Telegram при помощи бота</a>
* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>

<a id="tools"></a>

## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.jetbrains.com/ru-ru/idea/"><img width="6%" title="IntelliJ IDEA" src="media/icons/Idea.svg" alt="Intelij_IDEA"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/icons/Java.svg" alt="Java"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/icons/Selenide.svg" alt="Selenide"></a>
<a href="https://aerokube.com/selenoid/latest/"><img width="6%" title="Selenoid" src="media/icons/Selenoid.svg" alt="Selenoid"></a>
<a href="https://allurereport.org/"><img width="6%" title="Allure Report" src="media/icons/Allure.svg" alt="Allure_Report"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/icons/Allure_TO.svg" alt="AllureTestOps"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/icons/Gradle.svg" alt="Gradle"></a>
<a href="https://junit.org/junit5/docs/current/user-guide/"><img width="6%" title="JUnit5" src="media/icons/Junit5.svg" alt="JUnit5"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/icons/GitHub.svg" alt="GitHub"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/icons/Jenkins.svg" alt="Jenkins"></a>
<a href="https://tests.web.telegram.org/"><img width="6%" title="Telegram" src="media/icons/Telegram.svg" alt="Telegram"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/icons/Jira.svg" alt="Jira"></a>
<a href="https://rest-assured.io/"><img width="5%" title="RestAssured" src="media/icons/RestAssured.svg" alt="Jira"></a>
<a href="https://www.browserstack.com/"><img width="5%" title="Browserstack" src="media/icons/Browserstack.svg" alt="Jira"></a>
<a href="https://appium.io/"><img width="5%" title="Appium" src="media/icons/Appium.svg" alt="Jira"></a>
<a href="https://developer.android.com/studio"><img width="5%" title="Android_Studio" src="media/icons/Android_Studio.svg" alt="Jira"></a>
</p>

Автотесты в этом проекте написаны на `Java` использую `Selenide` фреймворк.

`Gradle` - используется как инструмент автоматизации сборки.\
`JUnit5` - для выполнения тестов.\
`REST Assured` - для тестирования REST-API сервисов.\
`Jenkins` - CI/CD для запуска тестов удаленно.\
`Selenoid` - для удаленного запуска браузера в `Docker` контейнерах.\
`Browserstack` - для запуска мобильных тестов удаленно.\
`Android Studio`, `Appium` - для запуска мобильных тестов локально на эмуляторе мобильных устройств.\
`Allure Report` - для визуализации результатов тестирования.\
`Allure TestOps` - как система управления тестированием.\
`Jira` — как инструмент управления проектом и таск-трекер.\
`Telegram Bot` - для уведомлений о результатах тестирования.

<a id="cases"></a>

## <a name="Реализованные проверки">**Реализованные проверки:**</a>

### Web

- Проверка заголовка страницы профиля
- Проверка авторизации c верными данными для входа
- Проверка выхода с авторизованного аккаунта
- Проверка навигационной панели домашней страницы
- Проверка смены языка
- Проверка создания проекта
- Проверка удаления проекта

### Api

- Выполнение запроса на авторизацию с верными данными для входа
- Выполнение запроса на авторизацию с неверными данными для входа
- Выполнение запроса на выход из аккаунта
- Выполнение запроса на создание нового проекта
- Выполнение запроса на удаление проекта

### Mobile

- Провека открытия главной страницы
- Проверка авторизации c верными данными
- Проверка авторизации с неверным данными
- Проверка перехода во вкладу "О компании"

  <a id="console"></a>

## Запуск тестов

Все конфигурационные файлы лежат в папке `resources` в файлах `.properties`.

### Локальный запуск тестов

#### Запуск всех тестов

```
gradle clean test
```

или

```
gradle clean test -Denv=local
```

#### WEB

```
gradle clean web
```

#### API

```
gradle clean api 
```

#### Mobile

```
gradle clean android -launch=emulator
```

### Удаленный запуск тестов

#### WEB

```
gradle clean test -Denv=remote
```

Параметры, которыми можно управлять:

```
-DbrowserName - наименование браузера. По умолчанию chrome
-DbrowserVersion - номер версии браузера. По умолчанию 100.0
-DbrowserSize - размер окна браузера. По умолчанию 1980x1080
-DremoteUrl - адрес удаленного сервера, на котором будут запускаться тесты
```

#### Mobile

```
gradle clean android -launch=browserstack
```

<a id="jenkins"></a>

## <img alt="Jenkins" height="25" src="media/icons/Jenkins.svg" width="25"/></a><a name="Сборка"></a>[Сборка в Jenkins](https://jenkins.autotests.cloud/job/Project%20Diplom_22/)</a>

____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/Lesson_17/"><img src="media/screen/Jenkins.png" alt="Jenkins" width="950"/></a>  
</p>

### **Параметры сборки в Jenkins:**

```
browserName (браузер, по умолчанию chrome)
browserVersion (версия браузера, по умолчанию 100.0)
browserSize (размер окна браузера, по умолчанию 1920x1080)
selenoidAddress (адрес удаленного сервера Selenoid)
```

<a id="allure"></a>

## <img src="media/icons/Allure.svg" title="Allure Report" width="4%"/> [Allure отчет](https://jenkins.autotests.cloud/job/Project%20Diplom_22/allure/)

### *Основная страница отчёта*

<p align="center">
<img title="Allure Overview" src="media/screen/Allure_report.png">
</p>

### *Тест-кейсы*

<p align="center">
<img title="Test Results in Alure" src="media/screen/Allure_result.png">
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="media/screen/Gra_1.png" width="850">

<img title="Allure Graphics" src="media/screen/Gra_2.png" width="850">  


<a id="allure-testops"></a>

## <img src="media/icons/Allure_TO.svg" title="Allure TestOps" width="4%"/> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/3950/dashboards)

### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/screen/Dashboards.png" width="850">  
</p> 

### *Авто тест-кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="media/screen/Allure_TO.png" width="850">  
</p>

<a id="jira"></a>

## <img alt="Allure" height="25" src="media/icons/Jira.svg" width="25"/></a> <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1040">Интеграция с Jira</a>

____
<p align="center">  
<img title="Jira" src="media/screen/Jira_report.png" width="850">  
</p>

<a id="telegram"></a>

## <img alt="Allure" height="25" src="media/icons/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

____
<p align="center">  
<img title="Telegram Bot Report" src="media/screen/Telegram_report.png" width="550">  
</p>

____
<a id="video"></a>

## <img alt="Selenoid" height="25" src="media/icons/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid

____
<p align="center">
<img title="Selenoid Video" src="media/video/Video_report.gif" width="550" height="350"  alt="video">   
</p>