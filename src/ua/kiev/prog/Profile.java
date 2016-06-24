package ua.kiev.prog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;



public class Profile extends HttpServlet {
    private final ConcurrentHashMap<String, Integer> language =   new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> prog =       new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> rank =       new ConcurrentHashMap<>();
    private final ArrayList<Integer> ages = new ArrayList<>();
    private final String    EN = "EN",          RU = "RU",          UA = "UA",
                            JAVA = "Java",      JS = "JS",          PHP = "PHP",        C_SHARP = "Csharp",
                            JUNIOR = "Junior",  MIDDLE = "Middle",  SENIOR = "Senior";

    {
        language.put(EN, 0);    prog.put(JAVA, 0);  rank.put(JUNIOR, 0);
        language.put(RU, 0);    prog.put(JS, 0);    rank.put(MIDDLE, 0);
        language.put(UA, 0);    prog.put(PHP, 0);   rank.put(SENIOR, 0);
        prog.put(C_SHARP, 0);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ages.add(Integer.parseInt(req.getParameter("age")));
        count(req.getParameter("language"), language);
        count(req.getParameter("prog"), prog);
        count(req.getParameter("rank"), rank);


        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><title>Statistics</title></head><body><table border=\"1\">"+
                    "<tr><th colspan=\"2\">Native language</th></tr>" +
                    "<tr><td>Englih</td><td>"+language.get(EN)+"</td></tr>" +
                    "<tr><td>Russian</td><td>"+language.get(RU)+"</td></tr>" +
                    "<tr><td>Ukrainian</td><td>"+language.get(UA)+"</td></tr>" +
                    "<tr><th colspan=\"2\">Priority programming language</th></tr>" +
                    "<tr><td>Java</td><td>"+prog.get(JAVA)+"</td></tr>" +
                    "<tr><td>JS</td><td>"+prog.get(JS)+"</td></tr>" +
                    "<tr><td>PHP</td><td>"+prog.get(PHP)+"</td></tr>" +
                    "<tr><td>C#</td><td>"+prog.get(C_SHARP)+"</td></tr>" +
                    "<tr><th colspan=\"2\">Ranks</th></tr>" +
                    "<tr><td>Junior</td><td>"+rank.get(JUNIOR)+"</td></tr>" +
                    "<tr><td>Middle</td><td>"+rank.get(MIDDLE)+"</td></tr>" +
                    "<tr><td>Senior</td><td>"+rank.get(SENIOR)+"</td></tr>" +
                    "<tr><th colspan=\"2\">Average age : "+countAverageAge(ages)+"</th></tr>"+
                    "</table></body></html>");

    }

    private double countAverageAge(ArrayList<Integer> ages) {
        int sum=0;
        for (int i : ages) {
            sum += i;
        }
        return sum / ages.size();
    }
        //comment
    private void count(String value, ConcurrentHashMap<String, Integer> map) {
        for (String key : map.keySet()) {
            if (key.equals(value)) map.put(key, map.get(key) + 1);
        }

    }
}
