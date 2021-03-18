package studey.advance.datastructure.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import studey.advance.datastructure.pojo.PermissionResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 * 多对多用户-角色-权限树
 */
@Data
@AllArgsConstructor
public class MultNode {
    private Integer id;
    private String userName;
    private List<RoleNode> roleNode;


    @Data
    public static class RoleNode{
        private Integer id;
        private String name;
        private List<Integer> parentIds;
        private Boolean areParent;
        private PermissionNode permission;
        private List<RoleNode> children = new ArrayList<>();

        public RoleNode(Integer id, String name, List<Integer> parentIds, Boolean areParent, PermissionNode permission) {
            this.id = id;
            this.name = name;
            this.parentIds = parentIds;
            this.areParent = areParent;
            this.permission = permission;
        }
    }


    @Data
    public static class PermissionNode extends SoloNode{
        private List<Integer> parentIds;

        public PermissionNode(List<Integer> parentIds, Integer id, Integer permissionLevelEnum, Integer parentId, Boolean areParent, PermissionResource permissionResource) {
            super(id, permissionLevelEnum, parentId, areParent, permissionResource);
            this.setParentId(parentId);
        }
    }

}

