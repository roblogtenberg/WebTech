angular.module('movieApp', [])
.controller('moviesController', ['$scope', '$window' ,'$http', '$log',function($scope, $window, $http, $log) {
  $http.get("api/ratings/get").success(function(data) {
    $scope.ratings = data;

    $http.get("api/movies/get").success(function(data) {
      $scope.movies = data;

      angular.forEach($scope.movies, function(movie, key) {
        $http.get("http://www.omdbapi.com/?t=" + movie.title + "&y=&plot=short&r=json").success(function(data) {
         movie.poster = data.Poster;
       });

        movie.rating = "There is no rating for this movie";
        movie.userRating = 0;

        angular.forEach($scope.ratings, function(value, key) {
          if(value.movie.title == movie.title) {
            movie.rating = value.rating;
          }
        });
      });
    });
  });

  $scope.login = function(token) {
    $scope.token = token;
    $log.log("Token: " + token);

    $http.get("api/ratings?token=" + token).success(function(data) {
      angular.forEach($scope.movies, function(movie, key) {
        angular.forEach(data, function(value, key) {
          if(movie.title == value.movie.title) {
            movie.userRating = value.rating;
            $log.log(movie.title + " value set to " + value.rating);
          }
        });
      });
    });
  };

  $scope.putRating = function(rating, imdbId) {
    if(angular.isUndefined($scope.token)) {
      $window.alert('You have to be logged on to rate a movie');
    } else {
      $http.post("api/ratings?rating=" + rating + "&imdbId=" + imdbId + "&token=" + $scope.token).success(function(data) {
        $log.log(data);
      });
    }
  };
}])
.controller("userListController", ['$scope', '$http', function($scope, $http){
  $http.get("api/users/get").success(function(data) {
    $scope.users = data;
  });
}]);