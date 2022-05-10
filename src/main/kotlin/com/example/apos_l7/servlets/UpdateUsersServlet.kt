package com.example.apos_l7.servlets

import com.example.apos_l7.servlets.api.DataProvider
import model.User
import javax.servlet.annotation.*
import javax.servlet.http.*


@WebServlet("/update-user")
class UpdateUsersServlet : HttpServlet() {

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
        servletContext.getRequestDispatcher("/updateUserForm.html").forward(request, response)
    }

    override fun doPost(request: HttpServletRequest, response: HttpServletResponse) {
        try {
            val id = request.getParameter("userId").toInt()
            val name = request.getParameter("userName")
            val surname = request.getParameter("userSurname")
            val country = request.getParameter("userCountry")

            val user = User(id, name, surname, country)

            DataProvider.sendUpdateRequest(user)

            response.sendRedirect(request.contextPath + "/get-user")
        } catch (ex: Exception) {
            ex.printStackTrace()
            servletContext.getRequestDispatcher("/get-user").forward(request, response)
        }
    }

    override fun destroy() {
    }
}