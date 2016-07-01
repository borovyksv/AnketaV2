package servlets;

import profileBeans.ProfileBean2;

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


@WebServlet("/profile2")
public class ProfileServlet2 extends HttpServlet {
    private List<ProfileBean2> data = Collections.synchronizedList(new ArrayList<>());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        if (req.getParameter("prog")!=null) {
            data.add(new ProfileBean2(req.getParameter("prog"),
                    req.getParameter("rank"),
                    Integer.parseInt(req.getParameter("exp"))));
        }

        if (data.isEmpty()) {req.setAttribute("prog_lang", null);}
        else {req.setAttribute("prog_lang", getProgLang());}
        req.setAttribute("rank", getRank());
        req.setAttribute("exp", getAverageExp());
        getServletContext().getRequestDispatcher("/profile_stat_2.jsp").forward(req, resp);


    }


    private String[] getProgLang() {
        AtomicInteger javaCounter = new AtomicInteger(0);
        AtomicInteger jsCounter = new AtomicInteger(0);
        AtomicInteger phpCounter = new AtomicInteger(0);
        AtomicInteger cCounter = new AtomicInteger(0);
        for (ProfileBean2 prof : data) {
            switch (prof.getProg()) {
                case "Java": javaCounter.getAndIncrement(); break;
                case "JS": jsCounter.getAndIncrement(); break;
                case "PHP": phpCounter.getAndIncrement(); break;
                case "Csharp": cCounter.getAndIncrement(); break;
            }
        }
        return new String[] {"Java : "+javaCounter.toString(),
                            "JS : "+jsCounter.toString(),
                            "PHP : "+phpCounter.toString(),
                            "Csharp : "+cCounter.toString(), };
    }
    private String[] getRank() {
        AtomicInteger jCounter = new AtomicInteger(0);
        AtomicInteger mCounter = new AtomicInteger(0);
        AtomicInteger sCounter = new AtomicInteger(0);
        for (ProfileBean2 prof : data) {
            switch (prof.getRank()) {
                case "Junior": jCounter.getAndIncrement(); break;
                case "Middle": mCounter.getAndIncrement(); break;
                case "Senior": sCounter.getAndIncrement(); break;
            }
        }
        return new String[] {"Junior : "+jCounter.toString(),
                            "Middle : "+mCounter.toString(),
                            "Senior : "+sCounter.toString(), };
    }

    private float getAverageExp() {
        int ageSum=0;
        for (ProfileBean2 prof : data) {
            ageSum += prof.getAge();
        }
        return (float) ageSum / data.size();

    }





}
