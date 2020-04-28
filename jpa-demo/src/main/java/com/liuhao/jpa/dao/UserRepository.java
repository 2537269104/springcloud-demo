package com.liuhao.jpa.dao;

import com.liuhao.jpa.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {




    List<UserEntity> findByUsernameLikeOrderByIdDesc(String name);

    //分页的时候指定查询条件
      Page<UserEntity> findByUsername(String username, Pageable pageable);

    //分页的时候指定模糊查询条件
    Page<UserEntity> findByUsernameLike(String username, Pageable pageable);

    //排序
    List<UserEntity> findByUsername(String username, Sort sort);

}
