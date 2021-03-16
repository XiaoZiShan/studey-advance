package studey.advance.datastructure.tree;

import lombok.Data;
import studey.advance.datastructure.pojo.PermissionResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 * 一对多权限Node 多树
 */
@Data
public class SoloNode {
    private Integer id ;
    private Integer permissionLevelEnum;
    private Integer parentId;
    private Boolean areParent;
    private PermissionResource permissionResource;
    private List<SoloNode> children = new ArrayList<>();

    public SoloNode(Integer id, Integer permissionLevelEnum, Integer parentId,Boolean areParent, PermissionResource permissionResource) {
        this.id = id;
        this.permissionLevelEnum = permissionLevelEnum;
        this.parentId = parentId;
        this.areParent = areParent;
        this.permissionResource = permissionResource;
    }
    
}