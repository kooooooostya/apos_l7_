package com.example.apos_l7.servlets

import com.example.apos_l7.servlets.api.DataProvider
import model.User

import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@WebServlet("/add-user")
class AddUsersServlet : HttpServlet() {

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        servletContext.getRequestDispatcher("/newUserForm.html").forward(request, response)
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        try {
            val name = request.getParameter("userName")
            val surname = request.getParameter("userSurname")
            val country = request.getParameter("userCountry")

            val user = User(-1, name, surname, country)

            DataProvider.sendAddUserRequest(user)

            response.sendRedirect(request.contextPath + "/get-user")

        } catch (ex: Exception) {
            ex.printStackTrace()
            servletContext.getRequestDispatcher("/get-user").forward(request, response)
        }
    }

    override fun destroy() {
    }
}