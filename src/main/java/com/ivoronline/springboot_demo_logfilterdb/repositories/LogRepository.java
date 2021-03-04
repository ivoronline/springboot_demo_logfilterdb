package com.ivoronline.springboot_demo_logfilterdb.repositories;

import com.ivoronline.springboot_demo_logfilterdb.entities.LogEntity;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogEntity, Integer> { }
