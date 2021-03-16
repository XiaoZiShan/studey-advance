package studey.advance.questiontypes.tree;

import studey.advance.datastructure.tree.SoloNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class SoloTreeCompleteSolution {
    
    /**
     * 展示多颗完整的一对多 Tree
     * @param nodeList 构建树的子节点
     * @return TreeList
     */
    protected List<SoloNode> viewCompleteSoloTree(List<SoloNode> nodeList){
        List<SoloNode> soloTreeList = new ArrayList<>();
        for(SoloNode node : getRootNode(nodeList)) {
            List<Integer> ids = new ArrayList<>();
            this.buildParentIds(soloTreeList,ids);
            SoloNode nodex = buildChilTree(node,nodeList,ids);
            
            if (Boolean.FALSE.equals(ids.contains(nodex.getId()))){
                soloTreeList.add(nodex);
            }
        }
        return soloTreeList;
    }
    
    /**
     * 为每个父节点递归 buildChilTree，建立子树形结构
     * @param pNode 需递归的父节点
     * @param nodeList 需递归的nodelist
     * @return 父节点Tree
     */
    private SoloNode buildChilTree(SoloNode pNode,List<SoloNode> nodeList,List<Integer> ids){
        List<SoloNode> childrens = new ArrayList<>();
        for(SoloNode node : nodeList) {
            if(node.getParentId().equals(pNode.getId())) {
                childrens.add(buildChilTree(node,childrens,ids));
            }
        }
        
        pNode.getChildren().addAll(childrens);
        return pNode;
    }
    
    /**
     * 获取 Tree 中的全部父节点id
     * @param nodeList Tree
     * @param ids 父节点ids
     */
    private void buildParentIds(List<SoloNode> nodeList, List<Integer> ids ){
        for(SoloNode node : nodeList) {
            if (Boolean.TRUE.equals(node.getAreParent())) {
                ids.add(node.getId());
                this.buildParentIds(node.getChildren(),ids);
            }
        }
    }
    
    /**
     * 获取根节点 rootLists
     * @param nodeList 全部节点list
     * @return 根节点list
     */
    private List<SoloNode> getRootNode(List<SoloNode> nodeList) {
        List<SoloNode> rootLists = new  ArrayList<>();
        for(SoloNode node : nodeList) {
            if (Boolean.TRUE.equals(node.getAreParent())) {
                rootLists.add(node);
            }
        }
        return rootLists;
    }
}