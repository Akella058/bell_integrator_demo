<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
    <style>
        table {
            font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif, serif;
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
    </style>
</head>
<body>
<h2 style="text-align: center;">Регистрация</h2>
<form method="post" action="/sign_up">
    <div style="text-align: center;">
        <table style="display: inline-block;">
            <tr>
                <td>
                    <input name="firstName"
                           type="text"
                           required="required"
                           placeholder="Введите имя"
                           pattern="[А-Яа-яЁё-\s]{,20}">
                </td>
                <td>
                    <input name="lastName"
                           type="text"
                           required="required"
                           placeholder="Введите фамилию"
                           pattern="[А-Яа-яЁё-\s]{,20}">
                </td>
            </tr>

            <tr>
                <td>
                    <input name="email"
                           type="email"
                           required="required"
                           placeholder="Введите email">
                </td>
                <td>
                    <input name="birthDate"
                           type="date"
                           id="birthdate"
                           required="required"
                </td>
            </tr>

            <tr>
                <td>
                    <input name="password"
                           type="password"
                           required="required"
                           placeholder="Введите пароль"
                           pattern="[a-zA-Z0-9]{8,30}"
                           title="от 8 до 30 символов содержащих цифры и латинские буквы">
                </td>
                <td>
                    <input name="passport"
                           type="text"
                           required="required"
                           placeholder="Введите номер паспорта"
                           pattern="[0-9]{10,10}"
                           title="10 цифр">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="Регистрация">
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>