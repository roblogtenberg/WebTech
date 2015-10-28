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
      $("#result").append('<img src="'+data['Poster']+'" alt="poster"/>');
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