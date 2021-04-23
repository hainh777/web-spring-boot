package com.laptrinhjava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjava.entity.NewEntity;

//tạo 1 interface thao tác với DB extends từ JpaRepository giá trị truyền vào là table sẽ thao tác ở database (đại diện NewEntity) và kiểu dữ liệu của khóa chính của table (Long) 
public interface INewRepository extends JpaRepository<NewEntity, Long>{

}
