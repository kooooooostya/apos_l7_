package com.example.apos_l7.servlets.api
import model.User

object DataProvider {

//    companion object {
//        @JvmStatic
//        fun main(args: Array<String>) {
//            val client = com.example.demo.temp.DataProvider()
//
//            client.sendGetRequest()
//            client.sendAddUserRequest(User(-1, "Name", "sur", "we"))
//            client.sendUpdateRequest(User(10, "Name", "sur", "we"))
//            client.sendDeleteRequest(10)
//        }
//    }


    fun getUsers(): List<User>{
        return Api.invoke().getUsers().execute().body()?.response ?: listOf()
    }

    fun sendDeleteRequest(id: Int) {
        Api.invoke().deleteUser(Api.DeleteBody(id)).execute()
    }

    fun sendAddUserRequest(user: User) {
        Api.invoke().addUser(Api.AddUserBody(user.name, user.surname, user.country)).execute()

    }

    fun sendUpdateRequest(user: User) {
        Api.invoke().updateUser(Api.UpdateUserBody(user.id, user.name, user.surname, user.country)).execute()
    }
}