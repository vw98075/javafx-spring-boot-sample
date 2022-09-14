package com.example.springjavafxh2.repository;

import com.example.springjavafxh2.entity.InputText;
import org.springframework.data.repository.CrudRepository;

public interface InputTextRepository extends  CrudRepository<InputText, Long>{

    Iterable<InputText> findAllByOrderByIdDesc();
}
