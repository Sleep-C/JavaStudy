package daimasuixianglu.动态规划;

public class SixtyTwo剑指2前缀树重要重写一遍 {
    //https://leetcode-cn.com/problems/QC3q1f/
    private SixtyTwo剑指2前缀树重要重写一遍[] children;
    private boolean isEnd;

    public SixtyTwo剑指2前缀树重要重写一遍() {
        children = new SixtyTwo剑指2前缀树重要重写一遍[26];
        isEnd = false;
    }

    public void insert(String word) {
        SixtyTwo剑指2前缀树重要重写一遍 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a'; 
            if (node.children[index] == null) {
                node.children[index] = new SixtyTwo剑指2前缀树重要重写一遍();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        SixtyTwo剑指2前缀树重要重写一遍 node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private SixtyTwo剑指2前缀树重要重写一遍 searchPrefix(String prefix) {
        SixtyTwo剑指2前缀树重要重写一遍 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
