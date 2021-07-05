package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Alien;


@RepositoryRestResource(collectionResourceRel="aliens",path="aliens")
public interface AlienRepository extends JpaRepository<Alien,Integer> {

	List<Alien> findByCourse(String course);
	List<Alien> findByAidGreaterThan(int aid);
	@Query("from Alien where course=?1 order by aname")
	List<Alien> findByCourseSorted(String course);
}
