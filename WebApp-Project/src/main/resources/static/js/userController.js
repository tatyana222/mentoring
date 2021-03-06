'use strict';

app.controller('userController', ['$scope', 'userService', '$location', function($scope, userService, $location) {
    var self = this;
    self.user={id:null, name:'', role:'', email:''};
    self.users=[];

    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.register = register;

    fetchAllUsers();

    function fetchAllUsers(){
        userService.fetchAllUsers()
            .then(
                function(d) {
                    self.users = d;
                },
                function(errResponse){
                    console.error('Error while fetching Users');
                }
            );
    }

    function createUser(user){
        userService.createUser(user)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while creating User');
                }
            );
    }

    function updateUser(user, id){
        userService.updateUser(user, id)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while updating User');
                }
            );
    }

    function register(){
        userService.createUser(self.user)
            .then(
                $location.path("/"),
                function(errResponse){
                    console.error('Error while creating User');
                }
            );
    }

    function deleteUser(id){
        userService.deleteUser(id)
            .then(
                fetchAllUsers,
                function(errResponse){
                    console.error('Error while deleting User');
                }
            );
    }

    function submit() {
        if(self.user.id===null){
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
        }
        reset();
    }

    function edit(id){
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }

    function remove(id){
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }


    function reset(){
        self.user={id:null, name:'', role:'', email:''};
        self.userForm.$setPristine(); //reset Form
    }

}]);