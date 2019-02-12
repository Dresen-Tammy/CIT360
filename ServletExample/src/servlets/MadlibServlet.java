package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDate.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "MadlibServlet", urlPatterns = {"/MadlibServlet"})
public class MadlibServlet extends HttpServlet {
    protected void
    doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String animal = request.getParameter("animal");
        String day = request.getParameter("day");
        String number = request.getParameter("number");
        String food = request.getParameter("food");
        String homework = request.getParameter("homework");
        Integer aNumber = -1;

        if (name == "" && name.trim().length() == 0) {
            name = "&lt;name&gt;";
        }

        if (animal == "" && animal.trim().length() == 0) {
            animal = "&lt;animal&gt;";
        }
        if (day == "" && day.trim().length() == 0) {
            day = "&lt;day&gt;";
        }
        if (number != "" && isANumber(number)) {
            aNumber = Integer.parseInt(number);
        }
        if (food == "" && food.trim().length() == 0) {
            food = "&lt;food&gt;";
        }
        if (homework == "" && homework.trim().length() == 0) {
            homework = "&lt;homework&gt;";
        }
        UserInput userInput = new UserInput(name,animal, day, aNumber, food, homework, LocalDate.now());


        request.setAttribute("userInput", userInput);
        request.getRequestDispatcher("madlib.jsp").forward(request, response);
    }

    public static boolean isANumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
