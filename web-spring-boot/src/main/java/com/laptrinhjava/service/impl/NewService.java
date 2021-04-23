package com.laptrinhjava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.repository.INewRepository;
import com.laptrinhjava.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private INewRepository newRepository;

	@Override
	public NewDTO save(NewDTO newDTO) {
		
		return null;
	}
}
