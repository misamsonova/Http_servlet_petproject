<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Cars</title>
    <style>
        body {
            font-family: 'Georgia', serif;
            background-color: #f8f8f8;
            padding: 20px;
        }
        span {
            font-size: 18px;
            line-height: 1.8;
            display: block;
            max-width: 800px;
            margin: auto;
            text-align: left;
        }
        h2 {
            margin-top: 30px;
            font-size: 24px;
        }
        iframe, img {
            max-width: 100%;
            height: auto;
            display: block;
            margin: 20px 0;
        }
        button {
            display: block;
            padding: 12px 24px;
            font-size: 18px;
            background-color: #6c757d;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 20px;
        }
        button:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
<c:if test="${requestScope.car.name_model == 'Porshe 718'}">
    <iframe width="1097" height="617"
            src="https://www.youtube.com/embed/i-M7KTLwBdE"
            title="Porsche 718 Cayman GTS 4.0: Völlig nutzlos, aber leider geil! - Test | auto motor und sport" frameborder="0" allow="accelerometer;
             autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" referrerpolicy="strict-origin-when-cross-origin" allowfullscreen></iframe>
    <img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_640.jpg" alt="Car image">
    <img src="https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_640.jpg" alt="Car image">
</c:if>
<span>Модель: Porsche 718 Cayman GTS 4.0
<br>Тип кузова: Купе
<br>Год выпуска: 2023
<br><br>Характеристики автомобиля:
<br>Двигатель: 4.0-литровый оппозитный 6-цилиндровый
<br>Мощность: 394 л.с.
<br>Коробка передач: 6-ступенчатая механическая
<br>Привод: Задний
<br>Разгон до 100 км/ч: 4,3 секунды
<br>Максимальная скорость: 293 км/ч
<br><br>Особенности и оборудование:
<br>Экстерьер: Спортивный аэродинамический обвес, 20-дюймовые легкосплавные диски, биксеноновые фары
<br>Интерьер: Кожаная отделка салона, спортивные сиденья с электронастройкой, многофункциональное рулевое колесо, система климат-контроля
<br>Технологии: Мультимедийная система с сенсорным экраном, навигационная система, Bluetooth, USB-порты, премиальная аудиосистема
<br>Безопасность: Система стабилизации, ABS, подушки безопасности, парктроники, камера заднего вида
<br><br>Условия аренды:
<br>Минимальный возраст водителя: 25 лет
<br>Стаж вождения: от 3 лет
<br>Депозит: 100 000 руб.
<br>Стоимость аренды: 25 000 руб. в сутки
<br>Пробег: Ограничение 250 км в сутки, превышение оплачивается отдельно
<br>Дополнительные услуги: Доставка автомобиля, аренда детского кресла, полное страхование
<br><br>Преимущества аренды:
<br>Арендуя Porsche 718 Cayman GTS 4.0, вы получаете уникальную возможность насладиться управлением одного из самых динамичных и спортивных автомобилей в своем классе. Этот автомобиль идеально подходит как для городских поездок, так и для загородных путешествий. Воплотите свои автомобильные мечты в реальность и почувствуйте настоящий драйв и комфорт за рулем Porsche.
<br><br>Контакты для бронирования:
<br>Телефон: +7 (495) 123-45-67
<br>Электронная почта: info@carrental.com
<br>Адрес: г. Москва, ул. Спортивная, д. 10
<br>Не упустите шанс испытать незабываемые ощущения от вождения Porsche 718 Cayman GTS 4.0!</span>
<h2>Количество свободных автомобилей:</h2>
<div><p>${requestScope.cars}</p></div>
<a href="${pageContext.request.contextPath}/create_order">
    <button type="button"><fmt:message key="page.cars.order.button"/>Rent</button>
</a>
</body>
</html>
