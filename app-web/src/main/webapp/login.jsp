<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="bootcamp protalento,
    mercado digital">
    <meta  name="keywords" content="jsp, protalento, bootcamp, educacion it">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
</head>
<body>
    <main>
        <table>
            <tr>
                <td>
                    <figure>
                        <img src="">
                        <figcaption></figcaption>
                    </figure>
                </td>
                <td>
                    <form action="<%=request.getContextPath()%>/LoginServlet" method="POST">
                        <input type="text" name="username">
                        <input type="password" name="password">
                        <input type="submit" value="Login">
                    </form>
                </td>
            </tr>
        </table>
    </main>

</body>
</html>