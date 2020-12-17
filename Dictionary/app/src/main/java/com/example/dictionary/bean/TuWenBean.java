package com.example.dictionary.bean;

import java.util.List;

public class TuWenBean {

    /**
     * words_result : [{"words":"悯农"},{"words":"锄禾日当午"},{"words":"汗滴禾下土。"},{"words":"谁知盘中餐"},{"words":"粒粒皆辛苦。"}]
     * log_id : 1339544087568580608
     * words_result_num : 5
     * direction : 0
     */

    private long log_id;
    private int words_result_num;
    private int direction;
    private List<WordsResultBean> words_result;

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(int words_result_num) {
        this.words_result_num = words_result_num;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public List<WordsResultBean> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<WordsResultBean> words_result) {
        this.words_result = words_result;
    }

    public static class WordsResultBean {
        /**
         * words : 悯农
         */

        private String words;

        public String getWords() {
            return words;
        }

        public void setWords(String words) {
            this.words = words;
        }
    }
}
