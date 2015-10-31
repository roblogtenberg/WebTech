function getPoster(movieName) {
  $.ajax({
    type:     "post",
    url:      "http://www.omdbapi.com/?t=" + movieName + "&y=&plot=short&r=json",
    dataType: "json",
    error: function(xhr, status, error) {
      alert("Uw inlognaam of wachtwoord is verkeerd");
    },
    success: function (data) {
      console.log(data['Poster']);
      $("#moviePoster").attr("src", data['Poster']);
    }
  });
}

function loginCheck(loginData, nickname) {
  $.ajax({
    type:     "post",
    contentType: "application/x-www-form-urlencoded",
    url:      "api/authentication",
    data: loginData,
    dataType: "text",
    error: function(xhr, status, error) {
      alert("Uw inlognaam of wachtwoord is verkeerd");
    },
    success: function (data) {
      $("#loginForm").css("display", "none");
      $("#submitButton").css("display", "none");
      $("#result").append("Welkom," + nickname);
    }
  });
}

$(document).ready(function(){
  $("#createAccountButton").click(function(){
    createUser($("#createUserForm").serialize());
  });
  $("#submitButton").click(function(){
    loginCheck($("#loginForm").serialize(), $("#nickname").val());
  });

  $.ajax({
    type:     "get",
    url:      "api/movies/get",
    dataType: "json",
    error: function(xhr, status, error) {
      alert("Er was een fout tijdens het ophalen van de movies");
    },
    success: function (data) {
      alert("get movie succes");    
      $.each(data, function(i, item) {
        getPoster(item.title);
        console.log(item.title);
      });
    }
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
      alert("Er gaat iets mis");
    },
    success: function (data) {
      alert("Niks aan de hand");
    }
  });
}

function getMovies() {
 $.ajax({
  type:     "get",
  url:      "api/movies/get",
  dataType: "json",
  error: function(xhr, status, error) {
    alert("Er was een fout tijdens het ophalen van de movies");
  },
  success: function (data) {
    alert("get movie succes");    
    $.each(data, function(i, item) {
      getPoster(item.title);
      console.log(item.title);
    });
  }
});
}