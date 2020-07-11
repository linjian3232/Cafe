package top.xeonwang.tmxk.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import top.xeonwang.tmxk.dao.AuthorMapper;
import top.xeonwang.tmxk.service.AuthorService;
@Service("AuthorService")
@Transactional
public class AuthorServiceImpl implements AuthorService
{
	@Resource
	private AuthorMapper authormapper;
	
	@Override
	public void AddAuthor(String AuthorId, String AuthorName)
	{
		// TODO Auto-generated method stub
		authormapper.AddAuthor(AuthorId, AuthorName);
	}

	@Override
	public void UpdateAuthor(String AuthorName)
	{
		// TODO Auto-generated method stub
		authormapper.UpdateAuthor(AuthorName);
	}

	@Override
	public void DropAuthor(String AuthorId)
	{
		// TODO Auto-generated method stub
		authormapper.DropAuthor(AuthorId);
	}

}
