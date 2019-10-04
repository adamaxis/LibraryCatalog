package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CheckoutDetails;
import model.ListItem;
import model.User;

/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	ListItemHelper lih = new ListItemHelper();
    	String transCode = request.getParameter("transCode");
    	System.out.println("Transaction code: "+ transCode);
    	String month = request.getParameter("month");
   		String day = request.getParameter("day");
   		String year = request.getParameter("year");
   		String userName = request.getParameter("userName");
   		LocalDate ld;
   		try {
    		ld = LocalDate.of(Integer.parseInt(year),
    		Integer.parseInt(month), Integer.parseInt(day));
   		}catch(NumberFormatException ex) {
    		ld = LocalDate.now();
   		}
   		String[] selectedItems =
   		request.getParameterValues("allItemsToAdd");
   		List<ListItem> selectedItemsInList = new ArrayList<ListItem>();
    		//make sure something was selected – otherwise we get a null pointer exception
    	if (selectedItems != null && selectedItems.length > 0) {
    		for(int i = 0; i<selectedItems.length; i++) {
    			System.out.println(selectedItems[i]);
    			ListItem c = lih.searchForItemById(Integer.parseInt(selectedItems[i]));
    			selectedItemsInList.add(c);
    		}
    	}
    	User user = new User(userName);
    	CheckoutDetails sld = new CheckoutDetails(transCode, ld, user);
    	sld.setListOfItems(selectedItemsInList);
    	CheckoutDetailsHelper slh = new CheckoutDetailsHelper();
    	slh.insertNewListDetails(sld);
    	getServletContext().getRequestDispatcher("/viewAllListsServlet").forward(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
