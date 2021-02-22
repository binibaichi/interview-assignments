package com.hy.shortmessage.dao;


import com.hy.shortmessage.domain.Shortmessage;

import java.util.List;
import java.util.Map;

public interface ShortmessageMapper {
	int deleteByPrimaryKey(Long id);

	int insert(Shortmessage record);

	int insertSelective(Shortmessage record);

	Shortmessage selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(Shortmessage record);

	int updateByPrimaryKey(Shortmessage record);

	Shortmessage selectByshortKey(String shortKey);
	
	Shortmessage selectShortMessage(Shortmessage record);

	/**
	 * 批量插入数据
	 * @param shortmessageList
	 * @return
	 */
	int insertBatch(List<Shortmessage> shortmessageList);

	/**
	 * 根据长链接获取数据
	 * @param originalUrl
	 * @return
	 */
	Shortmessage selectByOriginalUrl(String originalUrl);

	/**
	 * 根据短链接删除一条数据
	 */

	int deleteByShortKey(Map<String, Object> map);

	/**
	 * 根据短链接删除一条数据
	 */

	int deleteByShortKey2(String shortKey);


	/**
	 * 短信校验，根据tmpId进行
	 * @param originalUrl
	 * @return
	 */
	Shortmessage selectByOriginalLike(String originalUrl);


	/**
	 * 根据原始连接找到短链接
	 * @param originalUrl
	 * @return
	 */
	Shortmessage selectShortmessageByOriginalUrl(String originalUrl);

	/**
	 * 根据TmpId删除多条数据
	 */
	int deleteByOriginalLike(Map<String, Object> map);
}