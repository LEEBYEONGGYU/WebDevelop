package com.aboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller

public class PostController {
	@RequestMapping(value="/posts")
	public String write() throws Exception{
		return "/page/write";
	}
	
	@RequestMapping(value="/posts/{postid}")
	public String read() {
		return "/page/read";
	}
	
	@RequestMapping(value="/posts/{postid}/put")
	public String put() {
		return "/pgae/put";
	}
}
