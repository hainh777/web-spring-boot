package com.laptrinhjava.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjava.dto.NewDTO;

public interface INewService {
	NewDTO save (NewDTO newDTO);
	void delete(Long[] ids);
	List<NewDTO> findAll(Pageable pageable);
	List<NewDTO> findAll();
	List<NewDTO> findByTitleNative(String title);
	int tatalItem();
}
