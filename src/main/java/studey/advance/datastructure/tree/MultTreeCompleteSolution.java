package studey.advance.datastructure.tree;

import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class MultTreeCompleteSolution extends SoloTreeCompleteSolution{

    /**
     * 当前仅供演示用的新BuildTree思路, 代码严谨性后续完善
     * @param multNodes 未关联的多对多树
     * @param roleNodes 角色树
     * @param permissionNodes 权限树
     * @return 已关联的多对多树
     */
    protected List<MultNode> viewCompleteMultTree(List<MultNode> multNodes, List<MultNode.RoleNode> roleNodes , List<SoloNode> permissionNodes) {
        for (MultNode nodeX : multNodes) {

            // 遍历角色Tree (查询nodeX的角色节点并拼接组装)
            for (MultNode.RoleNode roleX : nodeX.getRoleNodes()) {
                for (MultNode.RoleNode roleY : roleNodes) {
                    if (roleY.getParentIds().contains(roleX.getId())) {
                        roleX.getChildren().add(roleY);
                        break;
                    }
                }

                // 用老的迭代树方式来递归权限树, 进行比较
                for (MultNode.PermissionNode permissionX : roleX.getPermissions()){
                    List<SoloNode> soloNodes = this.viewCompleteSoloTree(permissionNodes);
                    for (SoloNode soloNodeY: soloNodes){
                        if (permissionX.getId().equals(soloNodeY.getId())){
                            permissionX.setChildren(soloNodeY.getChildren());
                        }
                    }
                }
            }
        }
        return multNodes;
    }

}

