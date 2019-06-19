package com.teamword.repository;

import  java.util.List;

import com.teamword.model.Giuongbenh;
import org.springframework.data.repository.CrudRepository;
import  org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GiuongBenhRepository  extends CrudRepository<Giuongbenh,Integer>{
    public  List<Giuongbenh>  findByName(String Name);

    public List<Giuongbenh>  findById(int id);

    public  Giuongbenh getById(int id);
}
