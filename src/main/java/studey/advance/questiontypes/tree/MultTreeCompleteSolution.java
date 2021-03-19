package studey.advance.questiontypes.tree;

import studey.advance.datastructure.tree.MultNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class MultTreeCompleteSolution {
    protected List<MultNode> viewCompleteMultTree(List<MultNode> multNodes, List<MultNode.RoleNode> roleNodes ,List<MultNode.PermissionNode> permissionNodes){
        for (MultNode nodeX : multNodes) {

            for (MultNode.RoleNode roleX : nodeX.getRoleNode()) {
                // 二次迭代角色Tree (查询nodeX的父节点并拼接组装)
                // 标记roleX是否是有父节点
                boolean mark = false;
                for (MultNode.RoleNode roleY : roleNodes) {
                    if (nodeX.getRoleNode() == null) {
                        nodeX.setRoleNode(new ArrayList<>(1));
                    }
                    if (!roleY.getParentIds().isEmpty() && roleY.getParentIds().contains(nodeX.getId())) {
                        mark = true;
                        roleX.getChildren().add(roleY);
                        break;
                    }
    
                    // 二次迭代权限Tree (查询nodeX的父节点并拼接组装)
                    // todo 标记nodeX是否含有父节点
                    
                    
                }
                
                //当前节点无父节点则加入树中
                if (!mark) {
                    nodeX.getRoleNode().add(roleX);
                }
            }
           
        }
        
        return multNodes;
    }
    
}