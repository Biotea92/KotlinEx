package org.example.kotlin.`in`.action.`class`

class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int) = "FacebookName"
    }
}

fun main() {
    val subscribingUser = User.newSubscribingUser("bob@gamil.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickname)
}
