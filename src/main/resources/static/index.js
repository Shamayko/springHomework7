angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.ProductsList = response.data;
            });
    };

    $scope.deleteProduct = function (id) {
        $http.get(contextPath + '/products/delete/' + id)
            .then(function (response) {
                $scope.loadProducts();
            });
    }

    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadProducts();
        });
    }

    $scope.findProductsByCostBetween = function () {
        $http({
            url: contextPath + '/products/cost_between',
            method: 'GET',
            params: {
                min: $scope.filter.min,
                max : $scope.filter.max
            }
        }).then(function (response) {
            $scope.ProductsList = response.data;
        });
    }

    $scope.loadProducts();
});