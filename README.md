**WEATHER TEST for Corus**

*Задание:*

Тестовое задание следующее: написать веб приложение для отображения погоды.
Приложение должно позволять пользователям узнавать текущую погоду для конкретного
города или локации (долгота/широта) (не обязательно реальную, это могут быть
случайные данные - температура, ветер, давление... или данные с
http://openweathermap.org/api).
Реализовать страницу для ввода поисковой информации (например попросить
пользователя ввести город), так же страницу для отображения результатов поиска по
запросу.
Дополнительные  условия (не обязательно, но желательно):
    Приложение должно обрабатывать только один запрос за раз. Т.е. если несколько
пользователей &quot;одновременно&quot; выполнили поиск, их запросы становятся в очередь и
выполняются друг за другом. Пользователь должен информироваться о задержке и
автоматический перекидываться к результатам поиска, когда до него дойдет очередь.
Подумайте как это можно сделать эффективней, пользователей может быть очень много.
    Добавьте авторизацию для пользователей и статистику их работы с приложением: когда
зашел, какой запрос ввел, что получил. Это может быть просто текстовой файл с логом.