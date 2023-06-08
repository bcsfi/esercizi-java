<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Pagina Utente</title>
    <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }
    .container {
      max-width: 800px;
      margin: 0 auto;
      padding: 20px;
      background-color: #fff;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-top: 100px;
      position: relative;
    }
    h2 {
      text-align: center;
      margin-bottom: 30px;
    }
    .profile-image {
      display: block;
      width: 200px;
      height: 200px;
      border-radius: 50%;
      margin: 0 auto;
      background-image: url('path_to_image.jpg');
      background-size: cover;
      background-position: center;
    }
    .button-container {
      text-align: center;
      margin-top: 30px;
      margin-bottom: 50px;
    }
    .button-container button {
      background-color: #4CAF50;
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
      margin-right: 10px;
    }
    .button-container button:last-child {
      margin-right: 0;
    }
    .logout-button {
      position: absolute;
      bottom: 10px;
      right: 10px;
      background-color: #ff0000;
      border-radius: 5px;
    }
    .logout-button a {
      color: #fff;
      text-decoration: none;
      padding: 10px 20px;
    }
  </style>
</head>
<body>
<div class="container">
    <h2>Benvenuto nella tua pagina utente</h2>
    <div class="profile-image"></div>

    <div class="button-container">
        <button>Crea scheda</button>
        <button>Modifica scheda</button>
        <button>Scopri le schede altrui.</button>
        <a href="index.html">Home</a>
    </div>

    <div class="logout-button">
        <a href="#">Logout</a>
    </div>
</div>
</body>
</html>