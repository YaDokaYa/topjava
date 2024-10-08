package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Meal> meals = new ArrayList<>();
        meals.add(new Meal(LocalDateTime.now().minusHours(1), "Салат Цезарь", 150));
        meals.add(new Meal(LocalDateTime.now().plusHours(2), "Картофель по-деревенски", 600));
        meals.add(new Meal(LocalDateTime.now().minusHours(3), "Эскалоп из свинины", 2100));
        meals.add(new Meal(LocalDateTime.now().minusHours(4), "Фрукты:бананы", 200));

        List<MealTo> mealTos = new ArrayList<>();
        for (Meal meal : meals) {
            mealTos.add(
                    new MealTo(meal.getDateTime(), meal.getDescription(), meal.getCalories(), false));
        }
        log.debug("redirect to meals");
        request.setAttribute("mealss", mealTos);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}




