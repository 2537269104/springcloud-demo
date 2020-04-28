package com.liuhao.jpa.dao;

import com.liuhao.jpa.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

//持久层注解
@Repository
public class UserDao {

    @Autowired
    private EntityManager entityManager;


    /**
     * 新增 修改
     * 需要加Transactional的事务注解
     * @param userEntity
     * @return
     */
    @Transactional
    public UserEntity save(UserEntity userEntity){

        UserEntity merge = entityManager.merge(userEntity);

        return merge;
    }

    // 根据主键进行查询
    public UserEntity findById(Integer id){

        UserEntity userEntity = entityManager.find(UserEntity.class, id);

        return  userEntity;
    }


    /**
     * 按照id删除 先查询 删除的对象是受jpa管理的对象
     * @param id
     */
    @Transactional
    public void deleteById(Integer id){

        UserEntity byId = findById(id);

        entityManager.remove(byId);
    }


    /**
     * 查询所有数据
     * @return
     */
    public  List<UserEntity> findAll(){

        Query query = entityManager.createQuery("from UserEntity u");

        return query.getResultList();

    }

    /**
     *
     * @param username
     * @return
     */
    public  List<UserEntity> findByUsername(String username){

        Query query = entityManager.createQuery("from UserEntity u where username like :username ");

        String likeStr = "%".concat(username).concat("%");
        query.setParameter("username",likeStr);

        return query.getResultList();

    }

}
