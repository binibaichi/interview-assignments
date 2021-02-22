package com.hy.shortmessage.serviceimpl;

import javax.annotation.Resource;

import com.alicp.jetcache.anno.CacheInvalidate;
import com.alicp.jetcache.anno.CacheUpdate;
import com.alicp.jetcache.anno.Cached;
import com.hy.shortmessage.dao.ShortmessageMapper;
import com.hy.shortmessage.domain.Shortmessage;
import com.hy.shortmessage.service.IShortmessageService;
import org.springframework.stereotype.Service;



import java.util.Map;

@Service
public class ShortmessageServiceImpl implements IShortmessageService {

	@Resource
	ShortmessageMapper shortmessageDao;

	@Override
	public void saveShortmessage(Shortmessage shortmessage) {
		shortmessageDao.insertSelective(shortmessage);
	}

	@Override
	@Cached(name="ShortmessageServiceImpl:ShortmessageCache:",key="#shortKey")
	public Shortmessage selectShortmessageByShortKey(String shortKey) {
		return shortmessageDao.selectByshortKey(shortKey);
	}

	@Override
	public int deleteByShortKey(Map<String, Object> paramMap ) {
		return shortmessageDao.deleteByShortKey(paramMap);
	}

	@Override
	public int deleteByOriginalLike(Map<String, Object> map) {

		return shortmessageDao.deleteByOriginalLike(map);
	}

	@CacheInvalidate(name = "ShortmessageServiceImpl:ShortmessageCache:", key = "#shortKey")
	@Override
	public int deleteByShortKey2(String shortKey){
		return shortmessageDao.deleteByShortKey2(shortKey);
	}

	@Override
	public Shortmessage selectShortmessageByOriginalUrl(String originalUrl){
		return shortmessageDao.selectShortmessageByOriginalUrl(originalUrl);
	}


	@CacheUpdate(name = "ShortmessageServiceImpl:ShortmessageCache:", key = "#shortKey", value = "#shortmessage")
	public void updateShortmessage(String shortKey,Shortmessage shortmessage){
		shortmessage.setShortKey(shortKey);
		shortmessageDao.updateByPrimaryKey(shortmessage);
	}

}
