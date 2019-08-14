<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create User page</title>
</head>
<body>
<form name="user" action="/updateUser" method="post">
    <p>Id</p>
    <input title="id" type="text" name="id" value="${user.id}"/>
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${user.name}"/>
    <p>Age</p>
    <input title="Age" type="text" name="age" value="${user.age}"/>
    <p>Emai</p>
    <input title="Email" type="text" name="email" value="${user.email}"/>
    <input type="submit" value="ok">
</form>
</body>
</html>