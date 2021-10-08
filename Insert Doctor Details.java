

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Doctor_Insert")
public class Doctor_Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("fname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("iemail");
		String phone = request.getParameter("mobile");
		String hospital = request.getParameter("hospital");
		String specialty = request.getParameter("specialty");
		
		boolean isdoctor;
		
		isdoctor = DoctorDBUtil.InsertDoctor(name, gender, email, phone, hospital, specialty);
		
		if(isdoctor == true) { 
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
		}
		else {
			RequestDispatcher rd2 = request.getRequestDispatcher("unsuccess.jsp")
			rd2.forward(request, response);
		}
		 
	}

}
