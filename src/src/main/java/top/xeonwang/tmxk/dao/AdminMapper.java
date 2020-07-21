package top.xeonwang.tmxk.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface AdminMapper
{
	//新建管理员
	public void AddAdmin(@Param("AdminId") String AdminId,@Param("AdminName") String AdminName,@Param("AdminPos") String AdminPos);
	
	//修改管理员信息
	public void UpdateName(@Param("AdminId") String AdminId,@Param("AdminName") String AdminName);
	public void UpdatePos(@Param("AdminId") String AdminId,@Param("AdminPos") String AdminPos);
	
	//根据名字查找id
	public void FindByName(@Param("AdminName") String AdminName);
	
	//删除管理员
	public void DropAdmin(@Param("AdminId") String AdminId);
	
	//验证管理员
	public Integer ValidateAdmin(@Param("AdminName")String AdminName, @Param("AdminPwd")String AdminPwd);
}
