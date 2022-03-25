<%-- 
    Document   : create
    Created on : Mar 24, 2022, 1:43:40 PM
    Author     : Pierce
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    </head>
    <body>
        <h1>Edit User</h1>
        
        <form action="user?action=edit" method="post">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${email}" readonly required><br>
            <label for="active">Status:</label>
            <select type="select" id="active" name="active" >
                <option value="1">Active</option>
                <option value="0">Inactive</option>
            </select><br>
            <label for="first_name">First Name:</label>
            <input type="text" id="first_name" name="first_name" value="${first_name}" required=""><br>
            <label for="last_name">Last Name:</label>
            <input type="text" id="last_name" name="last_name" value="${last_name}" required><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="password" ><br>
            <label for="role_id">Role ID:</label>
            <select type="select" id="role_id" name="role_id" >
                <option value="1">System Admin</option>
                <option value="2">Regular User</option>
                <option value="3">Company Admin</option>
            </select><br>      
            <input type="submit">
        </form>
    </body>
</html>
