package com.laptrinhjava.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.dto.NewDTO;

@RestController
public class NewAPI {

	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		model.setComment("this is server value POST");
		return model;
	}
	@PutMapping(value = "/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		model.setComment("this is server value PUT");
		return model;
	}
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody Long ids) {
		//do some thing
	}
}
 