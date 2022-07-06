<%-- 
    Document   : login
    Created on : Jul 3, 2022, 11:10:00 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
       <link href="css/login.css" rel="stylesheet" type="text/css"/>
    </head>
   
    <body>
        <div class="header">
            <div class=header-tittle>
                <h1>
                    FPT University Academic Portal
                </h1>
            </div>
           <div class="header-logo">
            <img src="https://upload.wikimedia.org/wikipedia/vi/1/1d/Logo_%C4%90%E1%BA%A1i_h%E1%BB%8Dc_FPT.png" alt="">
          </div>

          <div>
        <table>
            <tr>
                <td><h3>Available on</h3></td>
                <td><a href="https://apps.apple.com/app/id1527723314">
                    <img src="https://fap.fpt.edu.vn/images/app-store.svg" style="width: 120px; height: 40px" alt="apple store"></a></td>
                <td>
                    <a href="https://play.google.com/store/apps/details?id=com.fuct">
                        <img src="https://fap.fpt.edu.vn/images/play-store.svg" style="width: 120px; height: 40px" alt="google store"></a>
                </td>   
            </tr>
           
        </table>
          </div>
          </div>
        <form action="login" method="post">
            <div class="body">
            <div class="login-page">           
                <div class="form">                 
                  <form class="login-form">
                    <input type="text" name="user" placeholder="username"/>
                    <input type="password" name="pass" placeholder="password"/>
                    <button>login</button>
                  </form>
                </div>
              </div>
        </form>

        </div>

        <div class="footwer">
            
        </div>




            

    </body>
</html>