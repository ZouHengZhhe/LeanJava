package com.zhhe.learnjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 *Author:ZouHeng
 *Des:
 *Date:2018-12-12 15:51
 */
public interface PersonRepository extends JpaRepository<Person,Long>
{
    List<Person> findAll();
}
