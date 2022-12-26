package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScoreController {

	private static int wins, losses, ties = 0;
	
	@RequestMapping({"/score"})
	public String getScore() {
		String pattren = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\":\"%s\", }";		
		return String.format(pattren, wins, losses, ties);
	}
	
	@RequestMapping(value = "/score", method = { RequestMethod.PUT})
	public String updateScore(@RequestParam int wins, 
								@RequestParam  int losses, 
								@RequestParam  int ties) {
		ScoreController.wins = wins;
		ScoreController.losses = losses;
		ScoreController.ties = ties;
		
		String pattren = "{ \"wins\":\"%s\", \"losses\":\"%s\", \"ties\":\"%s\", }";		
		return String.format(pattren, wins, losses, ties);
	}

	@RequestMapping({"/score/wins"})
	public String getWins() {
		String pattren = "{ \"wins\":\"%s\"}";		
		return String.format(pattren, wins);
	}

	@RequestMapping({"/score/losses"})
	public String getLosses() {
		String pattren = "{ \"losses\":\"%s\"}";		
		return String.format(pattren, losses);
	}

	@RequestMapping({"/score/ties"})
	public String getTies() {
		String pattren = "{ \"ties\":\"%s\" }";		
		return String.format(pattren, ties);
	}

	@RequestMapping(value = "/score/wins", method = { RequestMethod.POST})
	public String increaseWins() {
		++wins;
		String pattren = "{ \"wins\":\"%s\"}";		
		return String.format(pattren, wins);
	}

	@RequestMapping(value = "/score/losses", method = { RequestMethod.POST})
	public String increaseLosses() {
		++losses;
		String pattren = "{ \"losses\":\"%s\"}";		
		return String.format(pattren, losses);
	}

	@RequestMapping(value = "/score/ties", method = { RequestMethod.POST})
	public String increaseTies() {
		++ties;
		String pattren = "{ \"ties\":\"%s\" }";		
		return String.format(pattren, ties);
	}
}
