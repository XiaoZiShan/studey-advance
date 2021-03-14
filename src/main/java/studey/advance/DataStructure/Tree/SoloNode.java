package java.studey.advance.DataStructure.Tree;

import lombok.Data;

import java.studey.advance.DataStructure.Pojo.PermissionResource;
import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 * 一对多权限Node
 */
@Data
public class SoloNode {
    private Integer id ;
    private Integer permissionLevelEnum;
    private Integer parentId;
    private Boolean isParent;
    private PermissionResource permissionResource;
    private List<SoloNode> children;

    public SoloNode(Integer id, Integer permissionLevelEnum, Integer parentId, Boolean isParent, PermissionResource permissionResource) {
        this.id = id;
        this.permissionLevelEnum = permissionLevelEnum;
        this.parentId = parentId;
        this.isParent = isParent;
        this.permissionResource = permissionResource;
    }
}