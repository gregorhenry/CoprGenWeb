<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 10/2/17
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Sign-Up/Login Form</title>
  <link href='https://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" href="css/login.css">
</head>

<body>
<div class="form">

  <!--SIGN UP-->


  <ul class="tab-group">
    <li class="tab active"><a href="#signup">Sign Up</a></li>
    <li class="tab"><a href="#login">Log In</a></li>
  </ul>

  <div class="tab-content">
    <div id="signup">
      <h1>Sign Up for Free</h1>

      <form action="login" method="POST" >

        <fieldset>

          <input type="hidden" name="action" value="create"/>

          <div class="top-row">
          <div class="field-wrap">

              <label>
                First Name<span class="req">*</span>
              </label>

            <input type="text" name="name" id="name" value="${user.name}" required autocomplete="off" />
          </div>


          <div class="field-wrap">

              <label>
                Last Name<span class="req">*</span>

            </label>
            <input type="text" name="lastname" id="lastname" value="${user.lastname}" required autocomplete="off"/>
          </div>
        </div>

        <div class="field-wrap">

              <span class="req"></span>

          <input type="email" required autocomplete="off" name="email" id="email" value="${user.email}" placeholder="Email Address" />
        </div>

        <div class="field-wrap">
          <span class="req"></span>
          <input type="password" name="password" id="password" value="${user.password}" required autocomplete="off" placeholder="Password"/>
        </div>


        <button type="submit" class="button button-block"/>Get Started</button>

        </fieldset>

      </form>

      <!--LOGIN-->

    </div>

    <div id="login">
      <h1>Welcome Back!</h1>

      <form action="login" method="post">

        <input type="hidden" name="action" value="login"/>

        <div class="field-wrap">
          <label>
            <span class="req"></span>
          </label>
          <input type="email"required autocomplete="off" name="mail" id="mail" value="${user.email}" placeholder="Email Address"/>
        </div>

        <div class="field-wrap">
          <label>
            <span class="req"></span>
          </label>
          <input type="password"required autocomplete="off" name="pass" id="pass" value="${user.password}" placeholder="Password"/>
        </div>

        <p class="forgot"><a href="#">Forgot Password?</a></p>

        <button class="button button-block"/>Log In</button>

      </form>

    </div>

  </div><!-- tab-content -->

</div> <!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>


<script  src="js/login.js"></script>

</body>
</html>

