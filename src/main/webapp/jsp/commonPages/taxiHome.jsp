<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>


<html lang="${param.lang}">
<jsp:include page="../commonPartsOfPages/headTag.jsp"/>

<body class="home blog">

<div id="wrapper">
    <header id="header">
        <jsp:include page="../commonPartsOfPages/header_white.jsp"/>
        <div class="header_blue">
            <jsp:include page="../commonPartsOfPages/navi_block.jsp"/>

            <section class="slider_home">
                <div class="slides_nav_wrap">
                    <ul id="slides_nav"></ul>
                </div>
                <ul id="main_slider">
                    <li>
                        <img src="${pageContext.request.contextPath}/img/9.png" class="desktop-slide" width="960"
                             height="368">

                        <div class="slide_block">
                            <img src="${pageContext.request.contextPath}/img/9.png" class="mobile-slide" width="320"
                                 height="475">
                        </div>
                    </li>
                </ul>
            </section>
        </div>

    </header>
</div>


<section class="benefits_section">
    <div class="center">
        <ul class="benefits_list clearfix">
            <li class="around-clock">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Працюємо <br>цілодобово <br>24/7/365</span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
            <li class="taxi-online">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Замовити <br>таксі онлайн</span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
            <li class="taxi-station">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span
                                class="cell">Таксі в аеропорт, <br>на зал. вокзал, <br>автовокзал</span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
            <li class="low-rates">
                <a href="#" class="benefits_item">
	                <span class="benefits_inner">
	                    <span class="caption"><span class="cell">Низькі <br>тарифи</span></span>
	                    <span class="icon"></span>
	                </span>
                </a>
            </li>
        </ul>
    </div>
</section>


<section id="text_section" class="text_section">
    <div class="center text">
        <h1>Таксі в Києві онлайн </h1>
        <span>За статистикою таксі в Києві замовляють кожні 5 хвилин. Складно навіть уявити, наскільки актуальною може виявитися дана послуга, адже ситуації, коли необхідно вчасно бути в тому чи іншому місці трапляються постійно. Наша служба пропонує скористатися таксі в Києві та ще восьми містах України. У перспективі – розвиток і надання послуг на більшій території нашої держави та за її межами. Один з плюсів «838» – можливість замовити таксі (Київ) онлайн в інтернеті або через мобільний додаток, і це не єдина перевага нашої служби.</span>
        <h2><span>Служба таксі 838: наші переваги</span></h2>
        <ul>
            <li><span>Досвід роботи. На відміну від інших таксі Києва, наша компанія функціонує на ринку України більше 12-ти років. За цей період ми змогли організувати чітку і злагоджену роботу, пропонуючи максимальну оперативність та якість послуг.</span>
            </li>
            <li><span>Великий автопарк. Не всі таксі Києва можуть запропонувати великий вибір автомобілів. Як правило, в таксі (Київ) використовуються досить зношені машини середнього класу, які приїжджають без можливості вибору відповідного варіанту. Наша служба кардинально змінила підхід до даної сфери послуг! Наприклад, у такому місті, як Київ, таксі 838 володіє своїм власним автопарком, в якому є транспорт від середнього класу і вище.</span>
            </li>
            <li><span>Індивідуальний підхід до кожного клієнта. Таксі (Київ і не тільки) 838 – це уважне ставлення до наших замовників. Ваш дзвінок – і ми врахуємо всі особливості майбутнього шляху.</span>
            </li>
        </ul>
        <span>Якщо ви знаходитесь в одному з населених пунктів України, де працює наша компанія, або, зокрема, в місті Київ – таксі 838 стане для вас чудовою знахідкою, оскільки головні принципи, якими ми керуємося, це:</span>
        <ul>
            <li>
                <span>Задоволеність клієнта. При замовленні таксі (Київ, Львів, Маріуполь тощо), ми намагаємося зробити все, щоб клієнт залишився задоволений.</span>
            </li>
            <li>
                <span>Доступність. На відміну від інших таксі Києва, служба 838 дотримується демократичної цінової політики.</span>
            </li>
            <li>
                <span>Якість наданих послуг – невід'ємна частина нашої роботи.</span>
            </li>
        </ul>
        <h2><span>Оперативне таксі для тих, хто цінує свій час</span></h2>
        <span>Служба таксі (Київ) пропонує замовити найбільш прийнятну машину, зробивши лише один дзвінок. Завдяки унікальній системі «автопередзвонювання» наші фахівці зателефонують клієнту і уточнять час і місце початкового і кінцевого пункту. Крім того, щоб скористатися послугами, не обов'язково запам'ятовувати складні телефони і накопичувати візитки у своєму портмоне. Всі номери таксі (Київ) – це лише три прості цифри «838», набір яких для наших клієнтів є абсолютно безкоштовним.</span>
    </div>
</section>
<jsp:include page="../commonPartsOfPages/footer.jsp"/>
</body>
</html>