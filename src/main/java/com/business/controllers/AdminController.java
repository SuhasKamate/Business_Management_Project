package com.business.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.business.basiclogics.Logic;
import com.business.entities.Admin;
import com.business.entities.Orders;
import com.business.entities.Product;
import com.business.entities.User;
import com.business.services.AdminServices;
import com.business.services.OrderServices;
import com.business.services.ProductServices;
import com.business.services.UserServices;

@Controller
public class AdminController {

	private final UserServices userServices;
	private final AdminServices adminServices;
	private final ProductServices productServices;
	private final OrderServices orderServices;

	public AdminController(UserServices userServices, AdminServices adminServices,
			ProductServices productServices, OrderServices orderServices) {
		this.userServices = userServices;
		this.adminServices = adminServices;
		this.productServices = productServices;
		this.orderServices = orderServices;
	}

	// Resolve the currently logged-in customer from the security context.
	// This replaces the old mutable controller field that leaked data across users.
	private User currentUser(Authentication authentication) {
		if (authentication == null) {
			throw new IllegalStateException("No authenticated user in context");
		}
		return this.userServices.getUserByEmail(authentication.getName());
	}

	// ---------- Customer-facing (ROLE_USER) ----------

	// Search product by name
	@PostMapping("/product/search")
	public String searchHandler(@RequestParam("productName") String name, Model model,
			Authentication authentication) {
		User user = currentUser(authentication);
		Product product = this.productServices.getProductByName(name);

		model.addAttribute("name", user.getUname());
		model.addAttribute("orders", this.orderServices.getOrdersForUser(user));
		if (product == null) {
			model.addAttribute("message", "SORRY...!  Product Unavailable");
		}
		model.addAttribute("product", product);
		return "BuyProduct";
	}

	// Place order — price is taken from the database, never from the request
	@PostMapping("/product/order")
	public String orderHandler(@RequestParam("productName") String productName,
			@RequestParam("oQuantity") int quantity, Model model, Authentication authentication) {
		User user = currentUser(authentication);

		Product product = this.productServices.getProductByName(productName);
		if (product == null) {
			model.addAttribute("name", user.getUname());
			model.addAttribute("message", "SORRY...!  Product Unavailable");
			model.addAttribute("orders", this.orderServices.getOrdersForUser(user));
			return "BuyProduct";
		}

		double totalAmount = Logic.countTotal(product.getPprice(), quantity);

		Orders order = new Orders();
		order.setoName(product.getPname());
		order.setoPrice(product.getPprice());
		order.setoQuantity(quantity);
		order.setTotalAmmout(totalAmount);
		order.setUser(user);
		order.setOrderDate(new Date());
		this.orderServices.saveOrder(order);

		model.addAttribute("amount", totalAmount);
		return "Order_success";
	}

	@GetMapping("/product/back")
	public String back(Model model, Authentication authentication) {
		User user = currentUser(authentication);
		model.addAttribute("name", user.getUname());
		model.addAttribute("orders", this.orderServices.getOrdersForUser(user));
		return "BuyProduct";
	}

	// ---------- Admin-facing (ROLE_ADMIN) ----------

	@GetMapping("/admin/services")
	public String returnBack(Model model) {
		model.addAttribute("users", this.userServices.getAllUser());
		model.addAttribute("admins", this.adminServices.getAll());
		model.addAttribute("products", this.productServices.getAllProducts());
		model.addAttribute("orders", this.orderServices.getOrders());
		return "Admin_Page";
	}

	// Invoke AddAdmin page
	@GetMapping("/addAdmin")
	public String addAdminPage() {
		return "Add_Admin";
	}

	// Handle AddAdmin
	@PostMapping("/addingAdmin")
	public String addAdmin(@ModelAttribute Admin admin) {
		this.adminServices.addAdmin(admin);
		return "redirect:/admin/services";
	}

	// Invoke UpdateAdmin page
	@GetMapping("/updateAdmin/{adminId}")
	public String update(@PathVariable("adminId") int id, Model model) {
		model.addAttribute("admin", this.adminServices.getAdmin(id));
		return "Update_Admin";
	}

	// Handle update
	@PostMapping("/updatingAdmin/{id}")
	public String updateAdmin(@ModelAttribute Admin admin, @PathVariable("id") int id) {
		this.adminServices.update(admin, id);
		return "redirect:/admin/services";
	}

	// Handle delete
	@PostMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") int id) {
		this.adminServices.delete(id);
		return "redirect:/admin/services";
	}

	// Invoke AddProduct page
	@GetMapping("/addProduct")
	public String addProduct() {
		return "Add_Product";
	}

	// Invoke UpdateProduct page
	@GetMapping("/updateProduct/{productId}")
	public String updateProduct(@PathVariable("productId") int id, Model model) {
		model.addAttribute("product", this.productServices.getProduct(id));
		return "Update_Product";
	}

	// Invoke AddUser page
	@GetMapping("/addUser")
	public String addUser() {
		return "Add_User";
	}

	// Invoke UpdateUser page
	@GetMapping("/updateUser/{userId}")
	public String updateUserPage(@PathVariable("userId") int id, Model model) {
		model.addAttribute("user", this.userServices.getUser(id));
		return "Update_User";
	}
}
