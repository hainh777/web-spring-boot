package com.laptrinhjava.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjava.converter.NewConverter;
import com.laptrinhjava.dto.NewDTO;
import com.laptrinhjava.entity.CategoryEntity;
import com.laptrinhjava.entity.NewEntity;
import com.laptrinhjava.repository.ICategoryRepository;
import com.laptrinhjava.repository.INewRepository;
import com.laptrinhjava.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private INewRepository newRepository;
	@Autowired
	private ICategoryRepository categoryRepository;
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId() != null) {
			NewEntity oldEntityData = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldEntityData);
			
		}else {
			newEntity = newConverter.toEntity(newDTO);
			
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long item: ids) {
			newRepository.delete(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewEntity> entities = newRepository.findAll(pageable).getContent();
		for(NewEntity item: entities) {
			NewDTO newDTO = newConverter.toDTO(item);
			results.add(newDTO);
		}
		return results;
	}

	@Override
	public int tatalItem() {
		return (int) newRepository.count();
	}

}
