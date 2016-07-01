package servlets;

import profileBeans.ProfileBean3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@WebServlet("/profile3")
public class ProfileServlet3 extends HttpServlet {
    private List<ProfileBean3> data = Collections.synchronizedList(new ArrayList<>());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("salary")!=null) {
            data.add(new ProfileBean3(Integer.parseInt(req.getParameter("salary")),
                    Integer.parseInt(req.getParameter("work_time")),
                    req.getParameter("type")));
        }


        if (data.isEmpty()) {req.setAttribute("salaries", null);}
        else {req.setAttribute("salaries", getAverageSalary());}
        req.setAttribute("times", getAverageWorkTime());
        req.setAttribute("types", getType());
        getServletContext().getRequestDispatcher("/profile_stat_3.jsp").forward(req, resp);


    }


    private String[] getType() {
        AtomicInteger jCounter = new AtomicInteger(0);
        AtomicInteger mCounter = new AtomicInteger(0);
        AtomicInteger sCounter = new AtomicInteger(0);
        for (ProfileBean3 prof : data) {
            switch (prof.getJobType()) {
                case "distance": jCounter.getAndIncrement(); break;
                case "office": mCounter.getAndIncrement(); break;
                case "freelance": sCounter.getAndIncrement(); break;
            }
        }
        return new String[] {"Удаленно : "+jCounter.toString(),
                            "В офисе : "+mCounter.toString(),
                            "Фриланс : "+sCounter.toString(), };
    }

    private float getAverageSalary() {
        int ageSum=0;
        for (ProfileBean3 prof : data) {
            ageSum += prof.getSalary();
        }
        return (float) ageSum / data.size();

    }
    private float getAverageWorkTime() {
        int ageSum=0;
        for (ProfileBean3 prof : data) {
            ageSum += prof.getWorkTime();
        }
        return (float) ageSum / data.size();

    }





}
