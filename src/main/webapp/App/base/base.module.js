/**
 * Created by hadoop on 3/24/16.
 */

var baseModule = angular.module('base.module', ['ngRoute']);

baseModule.config(function($routeProvider){
    $routeProvider.when('/parkPriceList', {
        templateUrl : 'parkPriceList',
        controller : parkPriceController
    }).when('/next', {
        templateUrl : 'parkPriceList',
        controller : parkRegionController
    });
});

/*
baseModule.controller('parkPriceController', parkPriceController);
baseModule.controller('parkRegionController', parkRegionController);
*/
