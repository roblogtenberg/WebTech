angular.module('movieApp', [])
.controller('moviesController', ['$scope', '$window' ,'$http', '$log',function($scope, $window, $http, $log) {
  $http.get("api/ratings/get").success(function(data) {
    $scope.ratings = data;

    $http.get("api/movies/get").success(function(data) {
      $scope.movies = data;

      //get the posters of the movies
      angular.forEach($scope.movies, function(movie) {
        $http.get("http://www.omdbapi.com/?t=" + movie.title + "&y=&plot=short&r=json").success(function(data) {
         movie.poster = data.Poster;
       });

        //initialize rating and userRating
        movie.rating = "There is no rating for this movie";
        movie.userRating = 0;

        //set the ratings of the movies
        angular.forEach($scope.ratings, function(value) {
          if(value.movie.title == movie.title) {
            movie.rating = value.rating;
          }
        });
      });
    });
  });

  $scope.login = function(token) {
    $scope.token = token;

    //get the users ratings and update the model
    $http.get("api/ratings?token=" + token).success(function(data) {
      $scope.userRatings = data;
      angular.forEach($scope.movies, function(movie) {
        angular.forEach(data, function(value) {
          if(movie.title == value.movie.title) {
            movie.userRating = value.rating;
            $log.log(movie.title + " value set to " + value.rating);
          }
        });
      });
    });
  };

  $scope.putRating = function(rating, imdbId) {
    //check if the user is logged on
    if(angular.isUndefined($scope.token)) {
      $window.alert('You have to be logged on to rate a movie');
    } else {
      var mustPost = true;
      //check if the user has already rated the movie
      angular.forEach($scope.userRatings, function(value) {
        if(value.movie.imdbcode == imdbId) {
          $http.put("api/ratings?rating=" + rating + "&imdbId=" + imdbId + "&token=" + $scope.token);
          mustPost = false;
        }
      });
      //post the rating to the server and add the rating to the userRatings
      if(mustPost) {
        $http.post("api/ratings?rating=" + rating + "&imdbId=" + imdbId + "&token=" + $scope.token);
        $scope.userRatings.push({rating: rating, movie: {imdbcode: imdbId}});
      }
    }
  };

  $scope.removeRating = function(imdbId) {
    //check if the user is logged on
    if(angular.isUndefined($scope.token)) {
      $window.alert('You have to be logged on to remove your rating');
    } else {
      //delete the rating from the server
      $http.delete("api/ratings?imdbId=" + imdbId + "&token=" + $scope.token).success(function(data) {
        $window.alert('Rating removed');
        //reset the stars from the removed rating
        angular.forEach($scope.movies, function(movie) {
          if(movie.imdbcode == imdbId) {
            movie.userRating = 0;
          }
        });
      });
    }
  };
}])
.controller("userListController", ['$scope', '$http', function($scope, $http){
  //get the users
  $http.get("api/users/get").success(function(data) {
    $scope.users = data;
  });
}]);