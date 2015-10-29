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

function createUser(registerData, wachtwoord) {
  $.ajax({
    type:   "post",
    contentType: "application/x-www-form-urlencoded",
    url: "api/users"

  });
}

function getMovies() {
 $.ajax({
  type:     "get",
  url:      "api/movies/get",
  data:     "json",
  error: function(xhr, status, error) {
    alert("Er was een fout tijdens het ophalen van de movies");
  },
  success: function (data) {
    alert("get movie succes");
    console.log(data.movie['titel']);
    $.each(data, function(i, item) {
      console.log(item.titel);
      console.log(item['titel']);
      debugger;
      getPoster(item['titel']);
    });
  }
}); 
}