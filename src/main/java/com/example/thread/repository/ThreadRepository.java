package com.example.thread.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import com.example.thread.entity.ThreadEntity;
import com.example.thread.jpa.ThreadJpa;

@Repository
public class ThreadRepository {

	@Autowired
	ThreadJpa threadJpa;
	
	public void insertDB(String name,String message) {
		ThreadEntity threadEntity = new ThreadEntity();
		
		threadEntity.setName(name);
		threadEntity.setMessage(message);
		
		threadJpa.save(threadEntity);
		
	}
	
	public List<ThreadEntity> selectAll(){
		List<ThreadEntity>threadEntityList = threadJpa.findAll();
		
		return threadEntityList;
	}
	
	public ThreadEntity selectRecode(Integer id){
		ThreadEntity threadEntity = threadJpa.getOne(id);
		return threadEntity;
	}
	
	public void insertDB(Integer id,String name,String message){
		ThreadEntity threadEntity = new ThreadEntity();
		threadEntity.setId(id);
		threadEntity.setName(name);
		threadEntity.setMessage(message);
		threadJpa.save(threadEntity);
	}
		
	public void deleteRecode(Integer id){
		ThreadEntity threadEntity = new ThreadEntity();
		threadEntity.setId(id);
		threadJpa.deleteById(id);
	}
	
//	public Page<ThreadEntity> getPage(int pageNum){
//			
//		// new PageRequest(取得したいページ番号, 1ページあたりの件数, ソート条件)
//		Pageable pageable = PageRequest.of(pageNum,3,Sort.by(Direction.DESC,"id"));
//		// DBの内容をページ型で取得
//		Page<ThreadEntity> entityList =threadJpa.findAll(pageable);
//		return entityList;
//	}
	
public Page<ThreadEntity> findAll(Specification<ThreadEntity> searchConditions,Pageable pageable){
		
		Page<ThreadEntity> result =threadJpa.findAll(searchConditions,pageable);
		return result;
	}
	
}
