package java.studey.advance.QuestionTypes.Tree;

import java.studey.advance.DataStructure.Tree.SoloNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class SoloTreeCompleteSolution {
    public List<SoloNode> viewCompleteSoloTree(List<SoloNode> nodeList){
        List<SoloNode> soloTree =new ArrayList<>();
        for(SoloNode menuNode : getRootNode(nodeList)) {
            menuNode = buildChilTree(menuNode,nodeList);
            soloTree.add(menuNode);
        }
        return soloTree;
    }



    // 递归，建立子树形结构
    private SoloNode buildChilTree(SoloNode pNode,List<SoloNode> nodeList){
        List<SoloNode> chilMenus = new ArrayList<>();
        for(SoloNode menuNode : nodeList) {
            if(menuNode.getParentId().equals(pNode.getId())) {
                chilMenus.add(buildChilTree(menuNode,chilMenus));
            }
            pNode.setChildren(chilMenus);
        }
        return pNode;
    }

    //  如何优化父子结构的树,减少无效遍历速度
    private List<SoloNode> getRootNode(List<SoloNode> nodeList) {
        List<SoloNode> rootMenuLists =new  ArrayList<>();
        for(SoloNode menuNode : nodeList) {
            if(menuNode.getIsParent()) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }
}