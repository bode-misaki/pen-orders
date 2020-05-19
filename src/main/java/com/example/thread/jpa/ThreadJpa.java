package com.example.thread.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.thread.entity.ThreadEntity;

public interface ThreadJpa extends JpaRepository<ThreadEntity, Integer> ,JpaSpecificationExecutor<ThreadEntity>{

}
