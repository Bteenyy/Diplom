# Проект по автоматизации тестовых сценариев для проекта [Deeray](https://deeray.com/)

## Содержание:

* <a href="#tools">Технологии и инструменты</a>

* <a href="#cases">Реализованные проверки</a>

* <a href="#jenkins">Сборка в Jenkins</a>

* <a href="#console">Запуск из терминала</a>

* <a href="#allure">Allure отчет</a>

* <a href="#allure-testops">Интеграция с Allure TestOps</a>

* <a href="#jira">Интеграция с Jira</a>

* <a href="#telegram">Уведомление в Telegram при помощи бота</a>

* <a href="#video">Примеры видео выполнения тестов на Selenoid</a>

<a id="tools"></a>

## :computer: Использованный стек технологий

<p align="center">
<a href="https://www.jetbrains.com/ru-ru/idea/"><img width="6%" title="IntelliJ IDEA" src="media/Icons/Idea.svg" alt="Intelij_IDEA"></a>
<a href="https://www.java.com/"><img width="6%" title="Java" src="media/Icons/Java.svg" alt="Java"></a>
<a href="https://selenide.org/"><img width="6%" title="Selenide" src="media/Icons/Selenide.svg" alt="Selenide"></a>
<a href="https://aerokube.com/selenoid/latest/"><img width="6%" title="Selenoid" src="media/Icons/Selenoid.svg" alt="Selenoid"></a>
<a href="https://allurereport.org/"><img width="6%" title="Allure Report" src="media/Icons/Allure.svg" alt="Allure_Report"></a>
<a href="https://qameta.io/"><img width="5%" title="Allure TestOps" src="media/Icons/Allure_TO.svg" alt="AllureTestOps"></a>
<a href="https://gradle.org/"><img width="6%" title="Gradle" src="media/Icons/Gradle.svg" alt="Gradle"></a>
<a href="https://junit.org/junit5/docs/current/user-guide/"><img width="6%" title="JUnit5" src="media/Icons/Junit5.svg" alt="JUnit5"></a>
<a href="https://github.com/"><img width="6%" title="GitHub" src="media/Icons/GitHub.svg" alt="GitHub"></a>
<a href="https://www.jenkins.io/"><img width="6%" title="Jenkins" src="media/Icons/Jenkins.svg" alt="Jenkins"></a>
<a href="https://tests.web.telegram.org/"><img width="6%" title="Telegram" src="media/Icons/Telegram.svg" alt="Telegram"></a>
<a href="https://www.atlassian.com/ru/software/jira"><img width="5%" title="Jira" src="media/Icons/Jira.svg" alt="Jira"></a>
<a href="https://rest-assured.io/"><img width="5%" title="RestAssured" src="media/Icons/RestAssured.svg" alt="Jira"></a>
<a href="https://www.browserstack.com/"><img width="5%" title="Browserstack" src="media/Icons/Browserstack.svg" alt="Jira"></a>
<a href="https://appium.io/"><img width="5%" title="Appium" src="media/Icons/Appium.svg" alt="Jira"></a>
<a href="https://developer.android.com/studio"><img width="5%" title="Android_Studio" src="media/Icons/Android_Studio.svg" alt="Jira"></a>
</p>

<a id="cases"></a>

## <a name="Реализованные проверки">**Реализованные проверки:**</a>

### Web

- Проверка заголовка страницы профиля
- Проверка успешной авторизации
- Проверка выхода с аккаунта после успешной авторизации
- Проверка навигационной панели домашней страницы

### Api

- Выполнение успешного запроса на авторизацию
- Выполнение неудачного запроса на вход с неверным паролем
- Выполнение успешного запроса на выход из профиля
- Выполнени успешного запроса на создание нового проекта

### Mobile

- Провека успешного открытия главное страницы
- Проверка успешной авторизации
- Проверка неудачной авторизации с неверным паролем
- Проверка успешного перехода во вкладу "О компании"

## Запуск тестов

Все настройки лежат в папке `resources` в файлах `.properties`.

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

<a id="jenkins"></a>

## <img alt="Jenkins" height="25" src="media/Icons/Jenkins.svg" width="25"/></a><a name="Сборка"></a>Сборка в [Jenkins](https://jenkins.autotests.cloud/job/Project%20Diplom_22/)</a>

____
<p align="center">  
<a href="https://jenkins.autotests.cloud/job/Lesson_17/"><img src="media/Screen/Jenkins.png" alt="Jenkins" width="950"/></a>  
</p>

### **Параметры сборки в Jenkins:**
```
browserName (браузер, по умолчанию chrome)*
browserVersion (версия браузера, по умолчанию 100.0)*
browserSize (размер окна браузера, по умолчанию 1920x1080)*
selenoidAddress (адрес удаленного сервера Selenoid)*
```
<a id="console"></a>

## Команды для запуска из терминала

___
***Локальный запуск :***

```bash  
gradle clean scalablesolutions_test -Dlaunch=local
```

***Удаленный запуск в Selenoid :***

```bash  
gradle clean scalablesolutions_test -Dlaunch=remote
```

***Удалённый запуск через Jenkins :***

```bash  
clean scalablesolutions_test
"-DbrowserName=${browserName}"
"-DbrowserVersion=${browserVersion}"
"-DbrowserSize=${browserSize}"
"-DselenoidAddress=${selenoidAddress}"
```

<a id="allure"></a>

## <img src="media/Icons/Allure.svg" title="Allure Report" width="4%"/> Allure [отчет](https://jenkins.autotests.cloud/job/Project%20Diplom_22/21/allure/)

### *Основная страница отчёта*

<p align="center">
<img title="Allure Overview" src="media/Screen/Allure_report.png">
</p>

### *Тест-кейсы*

<p align="center">
<img title="Test Results in Alure" src="media/Screen/Allure_result.png">
</p>

### *Графики*

  <p align="center">  
<img title="Allure Graphics" src="media/Screen/Gra_1.png" width="850">

<img title="Allure Graphics" src="media/Screen/Gra_2.png" width="850">  


<a id="allure-testops"></a>

## <img src="media/Icons/Allure_TO.svg" title="Allure TestOps" width="4%"/> Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/3950/dashboards)

### *Allure TestOps Dashboard*

<p align="center">  
<img title="Allure TestOps Dashboard" src="media/Screen/Dashboards.png" width="850">  
</p> 

### *Авто тест-кейсы*

<p align="center">  
<img title="Allure TestOps Tests" src="media/Screen/Allure_TO.png" width="850">  
</p>

<a id="jira"></a>

## <img alt="Allure" height="25" src="media/Icons/Jira.svg" width="25"/></a> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1040">Jira</a>

____
<p align="center">  
<img title="Jira" src="media/Screen/Jira_report.png" width="850">  
</p>

<a id="telegram"></a>

## <img alt="Allure" height="25" src="media/Icons/Telegram.svg" width="25"/></a> Уведомление в Telegram при помощи бота

____
<p align="center">  
<img title="Telegram Bot Report" src="media/Screen/Telegram_report.png" width="550">  
</p>

____
<a id="video"></a>

## <img alt="Selenoid" height="25" src="media/Icons/Selenoid.svg" width="25"/></a> Примеры видео выполнения тестов на Selenoid

____
<p align="center">
<img title="Selenoid Video" src="media/Screen/Video_report.gif" width="550" height="350"  alt="video">   
</p>