package com.skilldistillery.meals.controllers;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.meals.entities.User;
import com.skilldistillery.meals.services.GroceryItemService;
import com.skilldistillery.meals.services.UserService;

@CrossOrigin({ "*", "http://localhost/" })
@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	GroceryItemService groceryService;

//	@GetMapping("myShoppingList")
//	public List<GroceryItem> displayShoppingList(Principal principal, HttpServletRequest req, HttpServletResponse res) {
//		List<GroceryItem> allItems = groceryService.index(principal.getName());
//		List<GroceryItem> shoppingList = userService.fullShoppingList(principal.getName());
//	
//		
//		if (shoppingList == null) {
//			res.setStatus(404);
//		} else {
//			res.setStatus(200);
//		}
//		return shoppingList;
//	}

//	@PutMapping("myShoppingList/{groceryItemId}")
//	public User addGroceryToShoppingList(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int groceryItemId) {
//		User updatedUser = userService.addToShoppingList(principal.getName(), groceryItemId);
//		if (updatedUser == null) {
//			res.setStatus(404);
//		} else {
//			res.setStatus(200);
//		}
//		return updatedUser;
//	}
	
	@DeleteMapping("myShoppingList/{groceryItemId}")
	public void removeGroceryFromShoppingList(Principal principal,
			HttpServletRequest req,
			HttpServletResponse res,
			@PathVariable int groceryItemId) {
		try {
			if (userService.removeFromGroceries(principal.getName(), groceryItemId)){
				res.setStatus(204);
			}else {
				res.setStatus(404);
			}
		}catch(Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	}
	
	@PutMapping("myShoppingList/{userId}")
	public User shoppingList(Principal principal, HttpServletRequest req, HttpServletResponse res, @PathVariable int userId, @RequestBody User user ) {
		User updatedUser =  userService.updateShoppingList(principal.getName(), userId, user);
		
		if (updatedUser == null) {
			res.setStatus(404);
		} else {
			res.setStatus(200);
		}
		return updatedUser;
	}
	
	@GetMapping("users")
	public List<User> getAllUsers(Principal principal, HttpServletRequest req, HttpServletResponse res){
		User user = userService.findByUsername(principal.getName());
		List<User>  allUsers = userService.findAll();
		if(allUsers != null && user.getRole() == "ADMIN") {
			res.setStatus(404);
		} else {
			res.setStatus(200);
		}
		return allUsers;
	}
	
	
}
