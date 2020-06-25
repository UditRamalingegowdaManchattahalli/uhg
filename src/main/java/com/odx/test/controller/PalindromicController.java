 package com.odx.test.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.odx.test.service.PalindromicService;


@RestController
@RequestMapping("/palindromic")
public class PalindromicController {
	
	@Autowired
	PalindromicService palindromicService;

	@PostMapping("/longestPalindromic")
	public @ResponseBody String getFindLongestPalindromic(
	        @RequestParam("text") String  text,HttpServletResponse response) throws Exception {
		try {
			//"To Find ":
			String palindromic = palindromicService.findPalindrome(text);
		return palindromic;
	     }
		catch (Exception exc) {
	         throw new ResponseStatusException(
	           HttpStatus.NOT_FOUND, "Failed to Generate Palindrome", exc);
	    }
	}
}

