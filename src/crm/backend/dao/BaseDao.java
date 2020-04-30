package crm.backend.dao;

import java.util.LinkedHashMap;
import java.util.List;

import com.mysql.cj.QueryResult;

public interface BaseDao {

	public void save(Object entity);

	public void update(Object entity);

	public <T> void delete(Class<T> entityClass, Object entityid);

	public <T> void delete(Class<T> entityClass, Object[] entityids);

	public <T> T find(Class<T> entityClass, Object entityid);

//	public <T> List<T> find(Class<T> entityClass);

	/**
	 * 获取分页数据的封装
	 *
	 * @param <T>
	 * @param entityClass 实体类
	 * @param firstindex  开始索引
	 * @param maxresult   需要获取的记录数
	 * @return
	 */
//	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult);

	/**
	 * 带排序功能的分页实现
	 *
	 * @param <T>
	 * @param entityClass
	 * @param firstindex
	 * @param maxresult
	 * @param orderby     按照添加的key的顺序排序
	 * @return
	 */
//	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult,
//			LinkedHashMap<String, String> orderby);

	/**
	 * 带排序功能的分页实现
	 *
	 * @param <T>
	 * @param entityClass
	 * @param firstindex
	 * @param maxresult
	 * @param wheresql    添加限制条件
	 * @param orderby
	 * @return
	 */
//	public <T> QueryResult<T> getScrollData(Class<T> entityClass, int firstindex, int maxresult, String wheresql,
//			Object[] queryParams, LinkedHashMap<String, String> orderby);

}
