package com.example.apos_l7.servlets

import com.example.apos_l7.servlets.api.DataProvider
import javax.servlet.annotation.*
import javax.servlet.http.*


@WebServlet(name = "get_users", value = ["/get-user"])
class GetUsersServlet : HttpServlet() {

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        response.contentType = "text/html"

        val out = response.writer

        val users = DataProvider.getUsers()

        out.println("<html><body>")

        out.println("<h1>Users:</h1>")

        users.forEach{
            out.println("<h2>$it</h2>")
        }
        out.println("</body></html>")

    }

    override fun destroy() {
    }
}