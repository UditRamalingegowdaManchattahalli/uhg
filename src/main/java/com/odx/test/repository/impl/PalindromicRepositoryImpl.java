package com.odx.test.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.odx.test.entity.Demo;
import com.odx.test.repository.PalindromicRepository;

@Repository
public class PalindromicRepositoryImpl implements PalindromicRepository {
	 @PersistenceContext
	private EntityManager entityManager;
	 public void savePalindrome(Demo demo) {
		 entityManager.persist(demo);
	 }
	 }


