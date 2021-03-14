package java.advance.DataStructure.testTree;

import java.util.ArrayList;
import java.util.List;

public class MenuTree {
    // https://www.cnblogs.com/lucky-pin/p/10740037.html
    /**
       　　1.首先从菜单数据中获取所有根节点。

     　　　2.为根节点建立次级子树并拼接上。

     　　　3.递归为子节点建立次级子树并接上，直至为末端节点拼接上空的“树”。
     */
    private List<Menu> menuList = new ArrayList<Menu>();

    public MenuTree(List<Menu> menuList) {
        this.menuList=menuList;
    }

    // 建立树形结构
    public List<Menu> builTree(){
        List<Menu> treeMenus =new  ArrayList<Menu>();
        for(Menu menuNode : getRootNode()) {
            menuNode=buildChilTree(menuNode);
            treeMenus.add(menuNode);
        }
        return treeMenus;
    }

    // 递归，建立子树形结构
    private Menu buildChilTree(Menu pNode){
        List<Menu> chilMenus = new ArrayList<Menu>();
        for(Menu menuNode : menuList) {
            if(menuNode.getParentId().equals(pNode.getId())) {
                chilMenus.add(buildChilTree(menuNode));
            }
        }
        pNode.setChildren(chilMenus);
        return pNode;
    }

    // 获取根节点
    private List<Menu> getRootNode() {
        List<Menu> rootMenuLists =new  ArrayList<Menu>();
        for(Menu menuNode : menuList) {
            if(menuNode.getParentId().equals("0")) {
                rootMenuLists.add(menuNode);
            }
        }
        return rootMenuLists;
    }
}
