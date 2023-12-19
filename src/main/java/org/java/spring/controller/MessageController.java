package org.java.spring.controller;

import java.util.List;

import org.java.spring.db.pojo.Message;
import org.java.spring.db.serv.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MessageController {

	@Autowired
	private MessageService messServ;
	
	@GetMapping("/message")
	public String getPhotosIndex(Model model,@RequestParam(name = "searchValue", required = false) String searchValue, Authentication authentication) {
		List<Message> message = searchValue == null ? messServ.findAll() : messServ.findByMessage(searchValue);
		
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("message", message);
		if(authentication != null) {
			model.addAttribute("username", authentication.getName());
		}

		return "messageIndex";
	}
	
	@GetMapping("/message/{id}")
	public String getPhotoDetail(Model model, @PathVariable int id) {
		model.addAttribute("message", messServ.findById(id));

		return "photoDetail";
	}
	
	@PostMapping("/message/{id}/delete")
	public String deletePhoto(@PathVariable int id) {
		Message message = messServ.findById(id);
		
		messServ.delete(message);
		
		return "redirect:/message";
	}
}
