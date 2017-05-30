package top.auok.cbps.ssm.dao.base;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import top.auok.cbps.ssm.model.page.PageBean;
import top.auok.cbps.ssm.model.page.PageParam;

public interface BaseDao<T> {

	SqlSession getSqlSession();

	SqlSessionTemplate getSessionTemplate();

	int insert(T entity);

	int insert(List<T> list);

	int delete(String id);

	int delete(List<T> list);

	int delete(Map<String, Object> paramMap);

	int update(T entity);

	int update(List<T> list);

	int update(Map<String, Object> paramMap);

	T getById(String id);

	T getById(Long id);

	T getByColumn(Map<String, Object> paramMap);

	T getBy(Map<String, Object> paramMap);

	List<T> listBy(Map<String, Object> paramMap);

	List<T> listByColumn(Map<String, Object> paramMap);

	Long getCountByColumn(Map<String, Object> paramMap);

	@SuppressWarnings("rawtypes")
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
}