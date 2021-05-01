package com.laptrinhjava.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.laptrinhjava.entity.NewEntity;

//tạo 1 interface thao tác với DB extends từ JpaRepository giá trị truyền vào là table sẽ thao tác ở database (đại diện NewEntity) và kiểu dữ liệu của khóa chính của table (Long) 
public interface INewRepository extends JpaRepository<NewEntity, Long>{
	@Query(value = "select * from db_webspringboot.new where title like :title ;",nativeQuery = true)
	List<NewEntity> findByTitleNative(@Param("title") String title);
}
