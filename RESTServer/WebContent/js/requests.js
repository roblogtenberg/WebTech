function loginCheck(loginData, nickname) {
  $.ajax({
    type:     "post",
    contentType: "application/x-www-form-urlencoded",
    url:      "api/authentication",
    data: loginData,
    dataType: "text",
    error: function(xhr, status, error) {
      alert("Your nickname or password is wrong!");
    },
    success: function (data) {
      var element = angular.element($('#movieContainer'));
      var controller = element.controller();
      var scope = element.scope();

      scope.$apply(function() {
        scope.login(data);
      })

      $("#loginForm").css("display", "none");
      $("#loginButton").css("display", "none");
      $("#result").append("Welkom," + nickname);
    }
  });
}

$(document).ready(function(){
  $("#createAccountButton").click(function(){
    if($("#password").val() == $("#passwordControl").val()) {
     createUser($("#createUserForm").serialize());
   } else {
    alert("The passwords don't match");
   }
 });

  $("#loginButton").click(function(){
    loginCheck($("#loginForm").serialize(), $("#nickname").val());
  });
});

function createUser(registerData) {
  $.ajax({
    type:   "post",
    contentType: "application/x-www-form-urlencoded",
    url: "api/users",
    data: registerData,
    dataType: "text",
    error: function(xhr, status, error) {
      alert("There wen't something wrong while creating a user!");
    },
    success: function (data) {
      alert("Account created");
      window.location.href = "/RESTServer/"
    }
  });
}