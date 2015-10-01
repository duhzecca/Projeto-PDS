package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DataDao;
import com.google.gson.Gson;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {                        
		response.setContentType("application/json");                
                System.out.println("ENTROU ENTROU");
		try {
			String term = request.getParameter("term");
			System.out.println("Data from ajax call " + term);                        
			DataDao dataDao = new DataDao();
			ArrayList<String> list = dataDao.getFrameWork(term);
                        
			String searchList = new Gson().toJson(list);
			response.getWriter().write(searchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}