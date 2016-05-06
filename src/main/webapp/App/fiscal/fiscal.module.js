/**
 * Created by hadoop on 3/24/16.
 */

var fiscalModule = angular.module('fiscal.module', ['ngRoute']);

baseModule.config(function($routeProvider){
    $routeProvider.when('/showFiscalList', {
        templateUrl : 'fiscalList',
        controller : fiscalController
    }).when('/next', {
        templateUrl : 'fiscalList',
        controller : fiscalController
    });
});

//baseModule.controller('fiscalController', fiscalController);
