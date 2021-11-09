<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!DOCTYPE html>
<html>
<head>
  <title>버킷리스트 등록</title>

  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
  
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    
    
  <style>

body {
    margin: 0;
    color: #green;
    background: white;
    font: 600 16px/18px 'Open Sans', sans-serif
}

.login-box {
    width: 100%;
    margin: auto;
    max-width: 525px;
    min-height: 670px;
    position: relative;
    background: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAACVBMVEXT5f3S5PzU5v72w4eZAAAB9UlEQVR4nO3P0UpcURREwbn+/0dnSAxM927zHigRFD2719TreV6vr/f3+8fHLz98vf/3fv91/vR58+RAPP7hTe59/f7/8/fd9/rz/QGf1+v5fP3nzT8+84uw8oSE803uERKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGENEsYJ4U0QEq4YYQ0SxgnhTRASrhhhDRLGCeFNEBKuGGEN/l/CX+7bKjHMwwWzAAAAAElFTkSuQmCC) no-repeat center;
    box-shadow: 0 12px 15px 0 rgba(0, 0, 0, .24), 0 17px 50px 0 rgba(0, 0, 0, .19)
}

.login-snip {
    width: 100%;
    height: 100%;
    position: absolute;
    padding: 90px 70px 50px 70px;
    background: lightblue;
}

.login-snip .login,
.login-snip .sign-up-form {
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    position: absolute;
    transform: rotateY(180deg);
    backface-visibility: hidden;
    transition: all .4s linear
}

.login-snip .sign-in,
.login-snip .sign-up,
.login-space .group .check {
    display: none
}

.login-snip .tab,
.login-space .group .label,
.login-space .group .button {
    text-transform: uppercase
}

.login-snip .tab {
    font-size: 22px;
    margin-right: 15px;
    padding-bottom: 5px;
    margin: 0 15px 10px 0;
    display: inline-block;
    border-bottom: 2px solid transparent
}

.login-snip .sign-in:checked+.tab,
.login-snip .sign-up:checked+.tab {
    color: #fff;
    border-color: #1161ee
}

.login-space {
    min-height: 345px;
    position: relative;
    perspective: 1000px;
    transform-style: preserve-3d
}

.login-space .group {
    margin-bottom: 15px
}

.login-space .group .label,
.login-space .group .input,
.login-space .group .button {
    width: 100%;
    color: #fff;
    display: block
}

.login-space .group .input,
.login-space .group .button {
    border: none;
    padding: 15px 20px;
    border-radius: 25px;
    background: rgba(255, 255, 255, .1)
}

.login-space .group input[data-type="password"] {
    text-security: circle;
    -webkit-text-security: circle
}

.login-space .group .label {
    color: #aaa;
    font-size: 12px
}

.login-space .group .button {
    background: #1161ee
}

.login-space .group label .icon {
    width: 15px;
    height: 15px;
    border-radius: 2px;
    position: relative;
    display: inline-block;
    background: rgba(255, 255, 255, .1)
}

.login-space .group label .icon:before,
.login-space .group label .icon:after {
    content: '';
    width: 10px;
    height: 2px;
    background: #fff;
    position: absolute;
    transition: all .2s ease-in-out 0s
}

.login-space .group label .icon:before {
    left: 3px;
    width: 5px;
    bottom: 6px;
    transform: scale(0) rotate(0)
}

.login-space .group label .icon:after {
    top: 6px;
    right: 0;
    transform: scale(0) rotate(0)
}

.login-space .group .check:checked+label {
    color: #fff
}

.login-space .group .check:checked+label .icon {
    background: #1161ee
}

.login-space .group .check:checked+label .icon:before {
    transform: scale(1) rotate(45deg)
}

.login-space .group .check:checked+label .icon:after {
    transform: scale(1) rotate(-45deg)
}

.login-snip .sign-in:checked+.tab+.sign-up+.tab+.login-space .login {
    transform: rotate(0)
}

.login-snip .sign-up:checked+.tab+.login-space .sign-up-form {
    transform: rotate(0)
}

*,
:after,
:before {
    box-sizing: border-box
}

.clearfix:after,
.clearfix:before {
    content: '';
    display: table
}

.clearfix:after {
    clear: both;
    display: block
}

a {
    color: inherit;
    text-decoration: none
}

.hr {
    height: 2px;
    margin: 60px 0 50px 0;
    background: rgba(255, 255, 255, .2)
}

.foot {
    text-align: center
}

.card {
    width: 500px;
    left: 100px
}

::placeholder {
    color: #b3b3b3
}
  </style>
</head>
<body>
<div class="row">
    <div class="col-md-6 mx-auto p-0">
        <div class="card">
            <div class="login-box">
                <div class="login-snip"> <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Login</label> <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">Sign Up</label>
                    <div class="login-space">
                        <div class="login">
                            <div class="group"> <label for="user" class="label">Username</label> <input id="user" type="text" class="input" placeholder="Enter your username"> </div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Enter your password"> </div>
                            <div class="group"> <input id="check" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Keep me Signed in</label> </div>
                            <div class="group"> <input type="submit" class="button" value="Sign In"> </div>
                            <div class="hr"></div>
                            <div class="foot"> <a href="#">Forgot Password?</a> </div>
                        </div>
                        <div class="sign-up-form">
                            <div class="group"> <label for="user" class="label">Username</label> <input id="user" type="text" class="input" placeholder="Create your Username"> </div>
                            <div class="group"> <label for="pass" class="label">Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Create your password"> </div>
                            <div class="group"> <label for="pass" class="label">Repeat Password</label> <input id="pass" type="password" class="input" data-type="password" placeholder="Repeat your password"> </div>
                            <div class="group"> <label for="pass" class="label">Email Address</label> <input id="pass" type="text" class="input" placeholder="Enter your email address"> </div>
                            <div class="group"> <input type="submit" class="button" value="Sign Up"> </div>
                            <div class="hr"></div>
                            <div class="foot"> <label for="tab-1">Already Member?</label> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

 
 



