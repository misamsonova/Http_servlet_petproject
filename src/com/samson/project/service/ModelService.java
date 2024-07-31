package com.samson.project.service;

import com.samson.project.dao.ModelDao;
import com.samson.project.dto.ModelDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class ModelService {
    public static final ModelService INSTANCE = new ModelService();
    private final ModelDao modelDao = ModelDao.getInstance();

    private ModelService(){
    }

    public List<ModelDto> findAll(){
        return modelDao.findAll().stream()
                .map(model -> ModelDto.builder().id(model.getId())
                        .description(
                                """
                                        %s
                                        """.formatted(model.getModel_name())
                        )
                        .build()
                )
                .collect(toList());

    }


    public static ModelService getInstance(){
        return INSTANCE;
    }
}
