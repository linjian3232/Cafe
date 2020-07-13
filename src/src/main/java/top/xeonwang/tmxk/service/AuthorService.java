package top.xeonwang.tmxk.service;

import org.springframework.stereotype.Service;

public interface AuthorService
{
	//新建权限
	public void AddAuthor(String AuthorId,String AuthorName);
	
	//修改权限
	public void UpdateAuthor(String AuthorName);
	
	//删除权限
	public void DropAuthor(String AuthorId);
}
