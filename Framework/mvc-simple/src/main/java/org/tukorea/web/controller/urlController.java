package org.tukorea.web.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class urlController {
	private static final Logger logger = LoggerFactory.getLogger(urlController.class);

	@RequestMapping(value="/try/{msg}", method=RequestMethod.GET)
	public String getUserTest(@PathVariable("msg") String msg) {
		logger.info(msg);
		logger.info("/try URL called. then getUserTest method executed.");
		return "result_a";
	}
	
	@RequestMapping(value="/tryA", method=RequestMethod.GET)
	public String getUserTest1(@RequestParam("msg") String msg, Model model) {
		logger.info(msg);
		logger.info("/tryA URL called. then getUserTest method executed.");
		model.addAttribute("msg", msg);
		return "result_a";
	}
	
}