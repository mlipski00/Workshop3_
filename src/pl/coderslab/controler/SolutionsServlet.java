package pl.coderslab.controler;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.model.Solution;
import pl.coderslab.model.SolutionDao;

/**
 * Servlet implementation class SolutionsServlet
 */
@WebServlet("/SolutionsServlet")
public class SolutionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolutionsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String numberSolutions = getServletContext().getInitParameter("number-solutions");
		int numberSolutionsInteger = 0;
		List<Solution> solutionsList = new ArrayList<>();
		try {
			numberSolutionsInteger = Integer.valueOf(numberSolutions);
		} catch (Exception e) {
			response.getWriter().append("Błąd parsowania contex param");
		}
		try {
			solutionsList = SolutionDao.loadAllSolutions(numberSolutionsInteger);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		}
		request.setAttribute("solutionsList", solutionsList);
		System.out.println(solutionsList);
		getServletContext().getRequestDispatcher("/WEB-INF/views/solutionsList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
