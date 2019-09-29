package top.wanda92632.blog.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface PermissionDao {
    Set<String> getPermissionsByUserName(@Param("permissionId")String permissionId);
}
