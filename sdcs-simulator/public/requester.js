var app = app || {};

(function() {
    'use strict';

    function makeRequest(method, url, data) {
        let promise = new Promise((resolve, reject) => {
            $.ajax({
                url,
                contentType: 'application/json',
                data: data || null,
                method,
                withCredentials: false,
                success(response) {
                    resolve(response);
                },
                error(error) {
                    reject(error);
                }
            });
        });

        return promise;
    }

    app.requester ={
        get(url) {
            return makeRequest('GET', url);
        },
        post(url, data) {
            return makeRequest('POST', url, data);
        },
        put(url, data) {
            return makeRequest('PUT', url, data);
        },
        delete(url) {
            return makeRequest('DELETE', url);
        }
    }
}());