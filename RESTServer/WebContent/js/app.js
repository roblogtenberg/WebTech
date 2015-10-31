angular.module('movieApp', [])
.controller('moviesController', ['$scope', '$http', '$log',function($scope, $http, $log) {
  $http.get("api/ratings/get").success(function(data) {
    $scope.ratings = data;
    $log.log($scope.ratings);

    $http.get("api/movies/get").success(function(data) {
      $scope.movies = data;

      angular.forEach($scope.movies, function(movie, key) {
        $http.get("http://www.omdbapi.com/?t=" + movie.title + "&y=&plot=short&r=json").success(function(data) {
         movie.poster = data.Poster;
       });

        movie.rating = "There is no rating for this movie";

        angular.forEach($scope.ratings, function(value, key) {
          if(value.movie.title == movie.title) {
            $log.log("set value" + movie.title);
            movie.rating = value.rating;
          }
        });
      });
    });
  });
}])
.controller("userListController", ['$scope', '$http', function($scope, $http){
  $http.get("api/users/get").success(function(data) {
    $scope.users = data;
  });
}]);