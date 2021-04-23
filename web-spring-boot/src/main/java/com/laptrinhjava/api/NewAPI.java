package com.laptrinhjava.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.service.INewService;

@RestController
public class NewAPI {

	@Autowired
	private INewService newServices;
	
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
	public Long[] deleteNew(@RequestBody Long[] ids) {
		Long[] idsr = {(long) 9, 8L, 7L};
		return idsr;
	}
}
 