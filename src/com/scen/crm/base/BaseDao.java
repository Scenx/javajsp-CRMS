package com.scen.crm.base;

import com.scen.crm.coursetype.domain.CrmCourseType;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

/**
 * 基础持久层通用类接口
 * @author Scen
 * @date 2018/2/18
 */
public interface BaseDao<T> {
    /**
     * 保存
     * @param t
     */
    void save(T t);

    /**
     * 更新
     * @param t
     */
    void update(T t);

    /**
     * 删除
     * @param t
     */
    void delete(T t);

    /**
     * 保存或者更新
     * @param t
     */
    void saveOrUpdate(T t);

    /**
     * 通过id查询
     * @param id
     * @return 一个查询到的对象
     */
    T findById(Serializable id);

    /**
     * 查询所有
     * @return 所有对象
     */
    List<T> findAll();

    /**
     * 分页查询总记录数
     *
     * @param condition
     * @param params
     * @return 分页查询总记录数
     */
    int getTotalRecord(String condition, Object[] params);

    /**
     * 分页，查询结果
     *
     * @param condition  条件
     * @param params     条件的实际参数
     * @param startIndex 开始索引
     * @param pageSize   每页显示个数
     * @return
     */
    List<T> findAll(String condition, Object[] params, int startIndex, int pageSize);

    /**
     * 离线条件查询 使用QBC
     * @param criteria
     * @return
     */
    List<T> findAll(DetachedCriteria criteria);

    /**
     * 分页
     * @param criteria
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<T> findAll(DetachedCriteria criteria,int startIndex,int pageSize);

}
