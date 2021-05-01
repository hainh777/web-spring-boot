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
	
	@GetMapping(value = "/api/new")
	public NewOutput showNew(@RequestParam(value = "page", defaultValue = "1") Integer page,
								@RequestParam(value = "limit", defaultValue = "-1") Integer limit,
								@RequestParam(value = "title", defaultValue = "none") String title) {
		NewOutput result = new NewOutput();
//		test thêm tìm kiếm theo title dùng native sql
		if(!title.equals("none")) {
			result.setListResult(newServices.findByTitleNative(title));
			return result;
		}
//		có phân trang khi page và limit có giá trị đúng
		if(limit > 0 && title.equals("none")) {
			result.setPage(page);
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(newServices.findAll(pageable));
			result.setTotalPage((int) Math.ceil((double) (newServices.tatalItem()) / limit));
		} else {
//			không phân trang
			result.setListResult(newServices.findAll());
		}
		return result;
	}
	@PostMapping(value = "/api/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return newServices.save(model);
	}
	@PutMapping(value = "/api/new/{id}")
	public NewDTO updateNew(@RequestBody NewDTO model, @PathVariable("id") Long id) {
		model.setId(id);
		return newServices.save(model);
	}
	@DeleteMapping(value = "/api/new")
	public void deleteNew(@RequestBody Long[] ids) {
		newServices.delete(ids);
	}
}
 