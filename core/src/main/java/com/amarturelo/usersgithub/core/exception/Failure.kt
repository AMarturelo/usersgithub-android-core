package com.amarturelo.usersgithub.core.exception

sealed class Failure:Error() {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object UnknownError : Failure()
}