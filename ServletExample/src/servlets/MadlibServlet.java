package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDate.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "MadlibServlet", urlPatterns = {"/MadlibServlet"})
public class MadlibServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInput userInput = new UserInput();
        String name = request.getParameter("name");
        String animal = request.getParameter("animal");
        String day = request.getParameter("day");
        String number =  request.getParameter("number");
        String food = request.getParameter("food");
        String homework = request.getParameter("homework");

        if (name != "" || name.trim().length() != 0) {
            userInput.setName(name);
        } else {
            userInput.setName("&lt;name&gt;");
        }
        if (animal != "" || animal.trim().length() != 0) {
            userInput.setAnimal(animal);
        } else {
        userInput.setAnimal("&lt;animal&gt;");
    }
        if (day != "" || day.trim().length() != 0) {
            userInput.setDay(day);
        } else {
            userInput.setDay("&lt;day&gt;");
        }
        if (number != "" && isANumber(number)) {
            userInput.setNumber(Integer.parseInt(number));
        } else {
            userInput.setNumber(0);
        }
        if (food != "" || food.trim().length() != 0) {
            userInput.setFood(food);
        } else {
            userInput.setFood("&lt;food&gt;");
        }
        if (homework != "" || homework.trim().length() != 0) {
            userInput.setHomework(homework);
        } else {
            userInput.setHomework("&lt;homework&gt;");
        }
        userInput.setDate(LocalDate.now());

        request.setAttribute("userInput", userInput);
        request.getRequestDispatcher("madlib.jsp").forward(request, response);
    }

    public static boolean isANumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
