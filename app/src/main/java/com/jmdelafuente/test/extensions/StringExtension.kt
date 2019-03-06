package com.jmdelafuente.test.extensions

fun Long.fromCentsToCurrency(): String {
    return (this / 100).toString()

}