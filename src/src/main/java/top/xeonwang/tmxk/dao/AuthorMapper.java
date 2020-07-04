package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;

public interface AuthorMapper
{
	//新建权限
	public void AddAuthor(@Param("AuthorId") String AuthorId,@Param("AuthorName") String AuthorName);
	
	//修改权限
	public void UpdateAuthor(@Param("AuthorName") String AuthorName);
	
	//删除权限
	public void DropAuthor(@Param("AuthorId") String AuthorId);
}
