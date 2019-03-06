package com.jmdelafuente.test.exceptions

class NetworkException(val code: Int, message:String): Exception(message)