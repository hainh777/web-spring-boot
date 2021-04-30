package com.laptrinhjava.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjava.api.output.NewOutput;
import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.service.INewService;

@RestController
public class NewAPI {

	@Autowired
	private INewService newServices;
	
	@GetMapping(value = "/new")
	public NewOutput showNew(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		NewOutput result = new NewOutput();
		result.setPage(page);
		Pageable pageable = new PageRequest(page - 1, limit);
		result.setListResult(newServices.findAll(pageable));
		result.setTotalPage((int) Math.ceil((double) (newServices.tatalItem()) / limit));
		return result;
	}
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newServices.save(model);
	}
	@PutMapping(value = "/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") Long id) {
		model.setId(id);
		return newServices.save(model);
	}
	@DeleteMapping(value = "/new")
	public void deleteNew(@RequestBody Long[] ids) {
		newServices.delete(ids);
	}
}
 