package com.learning.twentythree.dsalgo.array;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        System.out.println(new CrawlerLogFolder().minOperations(new String[]{"d1/","d2/","../","d21/","./"}));
        System.out.println(new CrawlerLogFolder().minOperations(new String[]{"d1/","d2/","./","d3/","../","d31/"}));
        System.out.println(new CrawlerLogFolder().minOperations(new String[]{"d1/","../","../","../"}));
    }

    public int minOperations(String[] logs) {
        int result = 0;
        for (int i = 0; i < logs.length; i++) {
            switch (logs[i]){
                case "../":
                    result = Math.max(--result, 0);
                    break;
                case "./":
                    break;
                default:
                    result++;
            }
        }
        return result;
    }
}
