package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;

@Controller
public class MessageController {
	 @Autowired
	    private MessageService messageService;
	
	 @RequestMapping(value = "/messagelist", method = RequestMethod.GET)
	    public String showMessage(ModelMap model) {
	        String name = getLoggedInUserName(model);
	        model.put("message", messageService.getMessageByUser(name));
	        return "messagelist";
	    }

	    private String getLoggedInUserName(ModelMap model) {
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails) {
	            return ((UserDetails) principal).getUsername();
	        }

	        return principal.toString();
	    }

	    @RequestMapping(value = "/addmessage", method = RequestMethod.GET)
	    public String showAddTodoPage(ModelMap model) {
	        model.addAttribute("message", new Message());
	        return "addmessage";
	    }

	    @RequestMapping(value = "/deletemessage", method = RequestMethod.GET)
	    public String deleteTodo(@RequestParam long id) {
	        messageService.deleteMessage(id);
	        return "redirect:/messagelist";
	    }

	    @RequestMapping(value = "/updatemessage", method = RequestMethod.GET)
	    public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
	        Message message = messageService.getMessageById(id).get();
	        model.put("message", message);
	        return "addmessage";
	    }

	    @RequestMapping(value = "/updatemessage", method = RequestMethod.POST)
	    public String updateTodo(ModelMap model, @Valid Message message, BindingResult result) {

	        if (result.hasErrors()) {
	            return "addmessage";
	        }

	        message.setUsername(getLoggedInUserName(model));
	        messageService.updateMessage(message);
	        return "redirect:/messagelist";
	    }

	    @RequestMapping(value = "/addmessage", method = RequestMethod.POST)
	    public String addMessage(ModelMap model, @Valid@ModelAttribute("message") Message message, BindingResult result) {
	    	System.out.println("inside addMessage==="+result);

	        if (result.hasErrors()) {
	            return "addmessage";
	        }

	        message.setUsername(getLoggedInUserName(model));
	        messageService.saveMessage(message);
	        return "redirect:/messagelist";
	    }

}
