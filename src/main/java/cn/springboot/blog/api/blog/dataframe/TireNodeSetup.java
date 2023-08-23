package cn.springboot.blog.api.blog.dataframe;
import java.util.*;
public class TireNodeSetup {
    static TireNode root = new TireNode(null);

//    将字符串插入字典树中，增加频次
    void setup(String sentence){
        for(Character c:sentence.toCharArray()){
            TireNode node = new TireNode(c);
            if(root.tireNodes.contains(node)){
                for(TireNode tireNode:root.tireNodes){
                    tireNode.features++;
                }
            }else{
                root.tireNodes.add(node);
            }
        }
    }

// 根据前缀获取符合要求的所有串
    List<TireNode> getTireNodeList(String prefix){
        TireNode start = getEndPrefixNode(prefix);
        return null;
    }

    TireNode getEndPrefixNode(String prefix){
        Set<TireNode> rootNodes = root.tireNodes;
        return dfs(rootNodes,prefix,0);
    }


    TireNode dfs(Set<TireNode> vals,String prefix,int idx){
        if(idx==prefix.length()-1){
            for(TireNode tireNode:vals){
                if(tireNode.val.equals(prefix.charAt(idx))){
                    return tireNode;
                }
            }
            return null;
        }

        for(TireNode tireNode:vals){
            if(tireNode.val.equals(prefix.charAt(idx))){
                return dfs(tireNode.tireNodes,prefix,idx+1);
            }
        }
        return null;
    }

    void dfs(Set<TireNode> vals,List<String> store,String tmp){
        if(vals.size()==0){
            store.add(tmp);
            return ;
        }
        for (TireNode val:vals){
//            获取12个结果即可
            if(vals.size()<13)
                dfs(val.tireNodes,store,tmp+val.val);
        }
    }
}
