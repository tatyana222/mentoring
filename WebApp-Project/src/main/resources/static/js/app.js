'use strict';

var app = angular.module("app", ['ngRoute']);

app.config(function ($httpProvider) {
    $httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';
});

app.controller("authController", function ($http, $location, $rootScope) {
    var self = this;

    var authenticate = function(credentials, callback) {

        var headers = credentials ? {
            Authorization: "Basic "
            + btoa(credentials.username + ":" + credentials.password)
        } : {};

        $http.get("/web-project/user", {headers : headers}).then(function (response) {
            var data = response.data;
            self.user = data.name;
            $rootScope.admin = data.roles && data.roles.indexOf("ROLE_ADMIN")>-1;
            $rootScope.authenticated = true;
            callback && callback();
        }, function () {
            self.user = "N/A";
            $rootScope.admin = false;
            $rootScope.authenticated = false;
            callback && callback();
        });
    };

    authenticate();
    self.credentials = {};
    self.login = function() {
        authenticate(self.credentials, function() {
            if ($rootScope.authenticated) {
                $location.path("/");
                self.error = false;
            } else {
                self.error = true;
            }
        });
    };

    self.logout = function () {
        $http.post('/web-project/logout', {}).then(function () {
            $rootScope.authenticated = false;
            $rootScope.admin = false;
            $location.path("/");
        }, function () {
            $rootScope.authenticated = true;
        });
    };
});

app.config(function ($routeProvider) {
    $routeProvider

        // route for the home page
        .when('/', {
            templateUrl: 'web-project/home.html',
            controller: 'mainController'
        })

        // route for the about page
        .when('/about', {
            templateUrl: 'web-project/about.html',
            controller: 'aboutController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl: 'web-project/contact.html',
            controller: 'contactController'
        })

        // route for the users page
        .when('/users', {
            templateUrl: 'web-project/users-list.html'
        })

        // route for the user registration
        .when('/registration', {
            templateUrl: 'web-project/registration.html'
        });
});

// create the controller and inject Angular's $scope
app.controller('mainController', function ($scope) {
    // create a message to display in our view
    $scope.message = 'Everyone come and see how good I look!';
});

app.controller('aboutController', function ($scope) {
    $scope.message = 'Look! I am an about page.';
});

app.controller('contactController', function ($scope) {
    $scope.message = 'Contact me! This is just a demo.';
});
