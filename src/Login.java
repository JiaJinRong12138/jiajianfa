import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        int result = 0;
        if(num1 != "" && num2 != "") {
            String f = request.getParameter("flag");
            int flag = Integer.parseInt(f);
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);
            switch (flag) {
                case 1:
                    result = n1 + n2;
                    break;
                case 2:
                    result = n1 - n2;
                    break;
                case 3:
                    result = n1 * n2;
                    break;
                case 4:
                    try {
                        result = n1 / n2;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        result = 0;
                        request.getSession().setAttribute("errorMsg", "被除数不能为0");
                    }
                    break;
                default:
                    break;
            }
        }else{
            request.getSession().setAttribute("errorMsg", "请输入数据");
        }
        request.setAttribute("result",result);
        request.getRequestDispatcher("/").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
