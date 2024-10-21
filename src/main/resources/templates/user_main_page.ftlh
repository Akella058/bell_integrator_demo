<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Личный кабинет</title>
    <style>
        table {

            font-size: 14px;
            border-collapse: collapse;
            text-align: center;
        }
        th, td:first-child {
            background: #AFCDE7;
            color: white;
            padding: 10px 20px;
        }
        th, td {
            border-style: solid;
            border-width: 0 1px 1px 0;
            border-color: white;
        }
        td {
            background: #D8E6F3;
        }
        th:first-child, td:first-child {
            text-align: left;
        }
        select {
            width: 100%;
        }
        input {
            width: 100%;
            box-sizing:border-box;
        }
        .div1 {
            display: inline-block;
        }
    </style>
</head>
<body>
<div style="display: inline-block;>
<h2 style="text-align: left;">Открыть счет</h2>
<form method="post" action="/accounts/create">
    <div style="text-align: left;">
        <table style="display: inline-block;">
            <tr>
                <td colspan="2">
                <select size="1" name="type" required>
                    <option selected="" disabled="" value=''>Выберите тип счета</option>
                    <option value="DEBIT"> Дебетовый</option>
                    <option value="CREDIT"> Кредитный</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Открыть счет">
                </td>
            </tr>
        </table>
    </div>
</form>
<h2 style="text-align: left;">Счета</h2>
<table>
    <tr>
        <th>Тип счета</th>
        <th>Номер счета</th>
        <th>Баланс</th>
    </tr>
    <#list accounts as account>
        <tr>
            <td>${account.type}</td>
            <td>${account.accountNumber}</td>
            <td>${account.balance}</td>
        </tr>
    </#list>
</table>
</div>
<h2 style="text-align: left;">Открыть карту</h2>
<form method="post" action="/cards">
    <div style="text-align: left;">
        <table style="display: inline-block;">
            <tr>
                <td colspan="2">
                    <select size="1" name="account" required>
                        <option selected="" disabled="" value=''>Выберите счет</option>
                        <#list accounts as account>
                        <option value="${account.accountNumber}">${account.accountNumber}</option>
                        </#list>
                    </select>
                    <select size="1" name="cardType" required>
                        <option selected="" disabled="" value=''>Выберите тип карты</option>
                        <option value="DEBIT"> Дебетовая</option>
                        <option value="CREDIT"> Кредитная</option>
                    </select>
                    <select size="1" name="paymentSystem" required>
                        <option selected="" disabled="" value=''>Выберите платежную систему</option>
                        <option value="MIR"> Мир</option>
                        <option value="VISA"> VISA</option>
                        <option value="MASTERCARD"> Mastercard</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Открыть карту">
                </td>
            </tr>
        </table>
    </div>
</form>
<h2 style="text-align: left;">Карты</h2>
<table>
    <tr>
        <th>Тип счета</th>
        <th>Номер счета</th>
        <th>Платежная система</th>
        <th>Статус карты</th>
        <th>Баланс</th>
    </tr>
    <#list cards as card>
        <tr>
            <td>${card.type}</td>
            <td>${card.cardNumber}</td>
            <td>${card.paymentSystem}</td>
            <td>${card.cardStatus}</td>
            <td>${card.cardBalance}</td>
        </tr>
    </#list>
</table>
<h2 style="text-align: left;">Пополнить или снять средства</h2>
<form method="post" action="/accounts/deposit_funds">
    <div style="text-align: left;">
        <table style="display: inline-block;">
            <tr>
                <td colspan="2">
                    <select size="1" name="cardNumber" required>
                        <option selected="" disabled="" value=''>Выберите карту</option>
                        <#list cards as card>
                        <option value="${card.cardNumber}">${card.cardNumber}</option>
                        </#list>
                    </select>
                    <select size="1" name="action" required>
                        <option selected="" disabled="" value=''>Пополнение или снятие</option>
                        <option value="IN"> Пополнить</option>
                        <option value="OUT"> Снять</option>
                    </select>
                </td>
                <td>
                <p><b>Сумма</b><br>
                    <input name="funds" type="text">
                </p>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Выполнить">
                </td>
            </tr>
        </table>
    </div>
</form>
<h2 style="text-align: left;">Активировать или заблокировать карту</h2>
<form method="post" action="/cards/change_status">
    <div style="text-align: left;">
        <table style="display: inline-block;">
            <tr>
                <td colspan="2">
                    <select size="1" name="cardNumber" required>
                        <option selected="" disabled="" value=''>Выберите карту</option>
                        <#list cards as card>
                        <option value="${card.cardNumber}">${card.cardNumber}</option>
                        </#list>
                    </select>
                    <select size="1" name="status" required>
                        <option selected="" disabled="" value=''>Пополнение или снятие</option>
                        <option value="ACTIVE"> Активировать</option>
                        <option value="BLOCKED"> Блокировать</option>
                        <option value="CLOSED"> Закрыть</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Выполнить">
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>