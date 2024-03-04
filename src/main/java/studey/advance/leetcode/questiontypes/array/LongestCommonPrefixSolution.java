package studey.advance.leetcode.questiontypes.array;

/**
 * Created by  刷题使我快乐,自律使我自由 !
 */
public class LongestCommonPrefixSolution {

    // https://leetcode-cn.com/problems/longest-common-prefix/submissions/
    //  比较差，照这我的思路继续下去的
    // 执行用时：
    //1 ms
    //, 在所有 Java 提交中击败了
    //69.48%
    //的用户
    //内存消耗：
    //36.8 MB
    //, 在所有 Java 提交中击败了
    //16.27%
    //的用户
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        String s = strs[0];
        while(j < s.length()){
            char c = s.charAt(j);
            boolean flag = true;
            for(int i = 1 ;i < strs.length ;i++){
                //情况1：当前j下标超过或等于其余单词的长度 直接报错
                //情况2：当前下标没有超过其余单词长度，但该单词与j所指不同，出错
                if(j >= strs[i].length() || strs[i].charAt(j) != c){
                    flag = false;
                    break;
                }
            }
            //报错则直接退出循环
            if(!flag){
                break;
            }
            //当前单词是公共前缀，可以加入
            sb.append(c);
            j++;
        }
        return sb.toString();
    }
}
