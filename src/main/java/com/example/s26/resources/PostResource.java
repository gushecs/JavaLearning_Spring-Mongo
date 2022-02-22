package com.example.s26.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.s26.domain.Post;
import com.example.s26.resources.util.URL;
import com.example.s26.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {

		Post u = service.findById(id);
		return ResponseEntity.ok().body(u);
	}
	
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam (value = "text", defaultValue = "") String text) {

		text = URL.decodeParam(text);
		List<Post> u = service.findByTitle(text);
		return ResponseEntity.ok().body(u);
	}
	
}
