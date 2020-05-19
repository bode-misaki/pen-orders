package com.example.thread.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.thread.entity.ThreadEntity;
import com.example.thread.repository.ThreadRepository;

@Service
public class ThreadService {

	@Autowired
	ThreadRepository threadRepository;
	public void insertDB(String name,String message) {
		threadRepository.insertDB(name,message);

	}
	public List<ThreadEntity> getAll(){
		List<ThreadEntity> threadEntityList = threadRepository.selectAll();
		return threadEntityList;
	}
	
	
	public ThreadEntity getRecode(Integer id){
		ThreadEntity threadEntity = threadRepository.selectRecode(id);
		return threadEntity;
	}
	
	public void insertDB(Integer id,String name,String message){
		threadRepository.insertDB(id,name,message);
	}
	
	public void deleteRecode(Integer id) {
		threadRepository.deleteRecode(id);
	}
	
	
	public Page<ThreadEntity> getPage(int pageNum,String searchName,String searchMessage){
//		Page<ThreadEntity> entityList = threadRepository.getPage(pageNum,searchName,searchMessage);
		
		Specification<ThreadEntity> searchConditions = Specification.where((Specification<ThreadEntity>)null);
		if(searchName != null && !searchName.isEmpty()) {
			Specification<ThreadEntity> searchCondition1 =(root,query,cb)->cb.like(root.get("name"),"%"+searchName+"%");
			searchConditions = searchConditions.and(searchCondition1);
		}
//		ThreadEntity.getName() ThreadEntity.getMessage()
		if(searchMessage != null && !searchMessage.isEmpty()) {
			Specification<ThreadEntity> searchCondition2 =(root,query,cb)->cb.like(root.get("message"),"%"+searchMessage+"%");
			searchConditions = searchConditions.and(searchCondition2);
		}
		Pageable pageable = PageRequest.of(pageNum<=0?0:pageNum,3,Sort.by(Direction.DESC,"id"));
		
		Page<ThreadEntity> result = threadRepository.findAll(searchConditions,pageable);
		return result;
	}
	
}
