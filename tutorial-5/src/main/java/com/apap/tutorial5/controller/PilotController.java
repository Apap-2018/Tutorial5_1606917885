package com.apap.tutorial5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.service.PilotService;

@Controller
public class PilotController {
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping("/")
	private String home(Model model) {
		model.addAttribute("title", "APAP");
		return "home";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.GET)
	private String add(Model model) {
		model.addAttribute("pilot", new PilotModel());
		model.addAttribute("title", "Add Pilot");
		return "addPilot";
	}
	
	@RequestMapping(value = "/pilot/add", method = RequestMethod.POST)
	private String addPilotSubmit(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Add Succeed");
		return "add";
	}
	
	@RequestMapping(value = "/pilot/view", method = RequestMethod.GET)
	private String viewPilotByLicenseNumber(@RequestParam ("licenseNumber") 
											String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		model.addAttribute("title", "View Pilot");
		return "view-pilot";
	}
	
	@RequestMapping(value = "/pilot/update/{licenseNumber}", method = RequestMethod.GET)
	private String updatePilot(@PathVariable (value = "licenseNumber", required=true) String licenseNumber, Model model) {
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		model.addAttribute("pilot", pilot);
		model.addAttribute("title", "Update Pilot");
		return "updatePilot";
	}
	
	@RequestMapping(value = "/pilot/update", method = RequestMethod.POST)
	private String updatePilot(@ModelAttribute PilotModel pilot, Model model) {
		pilotService.addPilot(pilot);
		model.addAttribute("title", "Update Succeed");
		return "update";
	}
	
	@RequestMapping(value = "/pilot/delete/{id}", method = RequestMethod.GET)
	private String deletePilot(@PathVariable (value = "id", required=true) long id, Model model) {
		pilotService.deletePilot(id);
		model.addAttribute("title", "Delete Succeed");
		return "delete";
	}
}
