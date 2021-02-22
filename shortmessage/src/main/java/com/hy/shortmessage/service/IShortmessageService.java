package com.hy.shortmessage.service;


import com.hy.shortmessage.domain.Shortmessage;

import java.util.Map;

public interface IShortmessageService {

	/**
	 * 
	 * @Title      : IShortmessageService 
	 * @Description: 保存短连接
	 * @param shortmessage     : 
	 * @author     : hanyang
	 * Create Date : 2018年10月11日 上午10:36:20
	 * @throws
	 */
	public void saveShortmessage(Shortmessage shortmessage);

	/**
	 * 
	 * @Title      : IShortmessageService 
	 * @Description: 根据shortkey获得短连接
	 * @param shortKey
	 * @return     : 
	 * @author     : hanyang
	 * Create Date : 2018年10月11日 上午10:36:29
	 * @throws
	 */
	public Shortmessage selectShortmessageByShortKey(String shortKey);


	/**
	 * 根据原始连接找到短链接
	 * @param originalUrl
	 * @return
	 */

	public Shortmessage selectShortmessageByOriginalUrl(String originalUrl);


	/**
	 * 根据短链接删除数据
	 * @param shortKey
	 * @return
	 */
	public int deleteByShortKey(Map<String, Object> map);

	/**
	 * 根据tmpId批量删除数据
	 * @param map
	 * @return
	 */
	public int deleteByOriginalLike(Map<String, Object> map);

	/**
	 * 根据短标识删除
	 * @param shortKey
	 * @return
	 */
	public int deleteByShortKey2(String shortKey);

}
