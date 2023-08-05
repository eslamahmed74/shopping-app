package com.example.shoppingapp.comman

sealed class Resource<T>(data: T?, message: String?) {

    class Loading<T>(data: T? = null) : Resource<T>(data = data, message = null)
    class Success<T>(data: T) : Resource<T>(data = data, message = null)
    class Error<T>(message: String) : Resource<T>(data = null, message = message)
}