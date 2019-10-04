package controller;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.CheckoutDetails;
import model.ListItem;
import model.User;

public class LibraryTester {
	public static void main(String[] args) {
		
		User susan = new User("Susan");
		CheckoutDetailsHelper ldh = new CheckoutDetailsHelper();
		ListItem book1 = new ListItem("C++: From Control Structures through Objects", "978-0-13-449837-9", "Tony Gaddis", "2017", "Computer Programming");
		ListItem book2 = new ListItem("ASP.NET CORE IN ACTION", "978-1-61729-461-77", "Andrew Lock", "2018", "Computer Programming");
		List<ListItem> susansItems = new ArrayList<ListItem>();
		susansItems.add(book1);
		susansItems.add(book2);
		CheckoutDetails susansList = new CheckoutDetails("123456", LocalDate.now(), susan);
		susansList.setListOfItems(susansItems);
		System.out.println(susansList.toString());
		ldh.insertNewListDetails(susansList);
		System.out.println("Here we are");
		List<CheckoutDetails> allLists = ldh.getLists();
		for(CheckoutDetails a: allLists) {
			System.out.println(a.toString());
		}
		/*User cameron = new User("Cameron");
		UserHelper sh = new UserHelper();
		sh.insertUser(cameron);
		CheckoutDetailsHelper ldh = new CheckoutDetailsHelper();
		CheckoutDetails cameronList = new CheckoutDetails("Cameron's List",
		LocalDate.now(), cameron);
		ldh.insertNewListDetails(cameronList);
		List<CheckoutDetails> allLists = ldh.getLists();
		for (CheckoutDetails a : allLists) {
			System.out.println(a.toString());
		}*/
		/*
			User bill = new User("Bill");
			UserHelper sh = new UserHelper();
			sh.insertUser(bill);
			List<User> allUsers = sh.showAllUsers();
			for(User a: allUsers) {
				System.out.println(a.toString());
			}*/
		
	}
}