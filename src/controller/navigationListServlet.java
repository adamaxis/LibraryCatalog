package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckoutDetails;
import model.ListItem;
import model.User;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationListServlet")
public class navigationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("doThisToItem");
		if (act == null) {
			 //no button has been selected
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").
			forward(request, response);
			} else if (act.equals("delete")) {
				try {
					int id = Integer.parseInt(request.getParameter("transID"));
					// delete checkout
					CheckoutDetailsHelper codh = new CheckoutDetailsHelper();
					CheckoutDetails codtd = codh.searchForListById(id);
					codh.deleteList(codtd);
					
					// delete user
					User utd = codtd.getUser();
					UserHelper uh = new UserHelper();
					uh.deleteUser(utd);
					
					ListItemHelper lh = new ListItemHelper();
					
					// delete books
					for(ListItem li : codtd.getListOfItems()) {
						lh.deleteItem(li);
					}
					
				} catch (NumberFormatException e) {
					System.out.println("Forgot to click a button");
				} finally {
					getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
				}
			} else if (act.equals("edit")) {
				System.out.println("Not implemented yet");
			} else if (act.equals("add")) {
				getServletContext().getRequestDispatcher("/new-list.html").forward(request, response);
			}
		
	}

}
