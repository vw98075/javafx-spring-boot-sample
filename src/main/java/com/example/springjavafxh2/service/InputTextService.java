package com.example.springjavafxh2.service;

import com.example.springjavafxh2.entity.InputText;
import com.example.springjavafxh2.repository.InputTextRepository;
import org.springframework.stereotype.Service;

@Service
public class InputTextService {

    private final InputTextRepository repository;

    public InputTextService(InputTextRepository repository) {
        this.repository = repository;
    }

    public InputText save(InputText text){
        return repository.save(text);
    }

    public long getTotal(){
        return repository.count();
    }
}
