package servlets;

import profileBeans.ProfileBean1;

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


@WebServlet("/profile1")
public class ProfileServlet1 extends HttpServlet {
    private List<ProfileBean1> data = Collections.synchronizedList(new ArrayList<>());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("firstName")!=null) {
            data.add(new ProfileBean1(req.getParameter("firstName"),
                    req.getParameter("secondName"),
                    Integer.parseInt(req.getParameter("age")),
                    req.getParameter("first_language"),
                    req.getParameter("second_language")));
        }

        if (data.isEmpty()) {req.setAttribute("users", null);}
        else {req.setAttribute("users", getUsers());}
        req.setAttribute("age", getAverageAge());
        req.setAttribute("first_lang", getFirstLang());
        req.setAttribute("sec_lang", getSecondLang());
        getServletContext().getRequestDispatcher("/profile_stat_1.jsp").forward(req, resp);


    }


    private String[] getFirstLang() {
        AtomicInteger enCounter = new AtomicInteger(0);
        AtomicInteger ruCounter = new AtomicInteger(0);
        AtomicInteger uagCounter = new AtomicInteger(0);
        for (ProfileBean1 prof : data) {
            switch (prof.getFirstLanguage()) {
                case "EN": enCounter.getAndIncrement(); break;
                case "RU": ruCounter.getAndIncrement(); break;
                case "UA": uagCounter.getAndIncrement(); break;
            }
        }
        return new String[] {"English : "+enCounter.toString(),
                            "Русский : "+ruCounter.toString(),
                            "Українська : "+uagCounter.toString(), };
    }
    private String[] getSecondLang() {
        AtomicInteger enCounter = new AtomicInteger(0);
        AtomicInteger ruCounter = new AtomicInteger(0);
        AtomicInteger uagCounter = new AtomicInteger(0);
        for (ProfileBean1 prof : data) {
            switch (prof.getSecondLanguage()) {
                case "EN": enCounter.getAndIncrement(); break;
                case "RU": ruCounter.getAndIncrement(); break;
                case "UA": uagCounter.getAndIncrement(); break;
            }
        }
        return new String[] {"English : "+enCounter.toString(),
                            "Русский : "+ruCounter.toString(),
                            "Українська : "+uagCounter.toString(), };
    }

    private float getAverageAge() {
        int ageSum=0;
        for (ProfileBean1 prof : data) {
            ageSum += prof.getAge();
        }
        return (float) ageSum / data.size();

    }

    private String[] getUsers() {
        ArrayList<String> list = new ArrayList<>();
        for (ProfileBean1 prof : data) {
            list.add(prof.getFirstName() + " " + prof.getSecondName());
        }
        return list.toArray(new String[list.size()]);
    }



}
