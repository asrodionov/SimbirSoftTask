# На выполнение задания ушло 8 часов.
Для запуска Selenium Grid нужно выполнить команды:
1. java -jar artifacts/selenium-server-standalone-3.141.59.jar -role hub
2. java -Dwebdriver.chrome.driver=C:\chromedriver.exe -jar artifacts/selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.0.100:4444/grid/register/ -port 5557 -browser browserName=chrome
