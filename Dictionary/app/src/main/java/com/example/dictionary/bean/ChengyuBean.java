package com.example.dictionary.bean;

import java.util.List;

public class ChengyuBean {

    /**
     * reason : success
     * result : {"bushou":"方","head":"旗","pinyin":"qí kāi dé shèng","chengyujs":" 刚一打开旗帜进入战斗，就取得了胜利。比喻事情刚一开始，就取得好成绩。","from_":" 元·无名氏《射柳捶丸》第四折：\u201c托赖主人洪福，旗开得胜，马到成功。\u201d","example":" ～姜文焕，一怒横行劈董忠。 明·许仲琳《封神演义》第九十四回","yufa":" 连动式；作谓语；含褒义","ciyujs":"[win in the first battle] 战旗一展开就取胜,比喻一举成功或事情一开始就取得成果","yinzhengjs":"令旗一扬就获得胜利。极言战争胜利之速。亦比喻事情一开始就取得成功。 元 李文蔚 《蒋神灵应》楔子：\u201c显威灵神兵扶助，施谋略旗开得胜。\u201d 明 黄元吉 《流星马》第一折：\u201c我旗开得胜，马到成功。\u201d《痛史》第二五回：\u201c此时兴兵恢復，是代全 中国 人驱除腥膻污秽之气，岂是为我 赵氏 一家之事？望二位旗开得胜，肃清宇内。\u201d 老舍 《女店员》第三幕：\u201c我预祝妇女商店旗开得胜，成为 北京市 的一面红旗。\u201d","tongyi":["马到成功","百战百胜"],"fanyi":["一触即溃","丢盔弃甲"]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * bushou : 方
         * head : 旗
         * pinyin : qí kāi dé shèng
         * chengyujs :  刚一打开旗帜进入战斗，就取得了胜利。比喻事情刚一开始，就取得好成绩。
         * from_ :  元·无名氏《射柳捶丸》第四折：“托赖主人洪福，旗开得胜，马到成功。”
         * example :  ～姜文焕，一怒横行劈董忠。 明·许仲琳《封神演义》第九十四回
         * yufa :  连动式；作谓语；含褒义
         * ciyujs : [win in the first battle] 战旗一展开就取胜,比喻一举成功或事情一开始就取得成果
         * yinzhengjs : 令旗一扬就获得胜利。极言战争胜利之速。亦比喻事情一开始就取得成功。 元 李文蔚 《蒋神灵应》楔子：“显威灵神兵扶助，施谋略旗开得胜。” 明 黄元吉 《流星马》第一折：“我旗开得胜，马到成功。”《痛史》第二五回：“此时兴兵恢復，是代全 中国 人驱除腥膻污秽之气，岂是为我 赵氏 一家之事？望二位旗开得胜，肃清宇内。” 老舍 《女店员》第三幕：“我预祝妇女商店旗开得胜，成为 北京市 的一面红旗。”
         * tongyi : ["马到成功","百战百胜"]
         * fanyi : ["一触即溃","丢盔弃甲"]
         */

        private String bushou;
        private String head;
        private String pinyin;
        private String chengyujs;
        private String from_;
        private String example;
        private String yufa;
        private String ciyujs;
        private String yinzhengjs;
        private List<String> tongyi;
        private List<String> fanyi;

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getChengyujs() {
            return chengyujs;
        }

        public void setChengyujs(String chengyujs) {
            this.chengyujs = chengyujs;
        }

        public String getFrom_() {
            return from_;
        }

        public void setFrom_(String from_) {
            this.from_ = from_;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getYufa() {
            return yufa;
        }

        public void setYufa(String yufa) {
            this.yufa = yufa;
        }

        public String getCiyujs() {
            return ciyujs;
        }

        public void setCiyujs(String ciyujs) {
            this.ciyujs = ciyujs;
        }

        public String getYinzhengjs() {
            return yinzhengjs;
        }

        public void setYinzhengjs(String yinzhengjs) {
            this.yinzhengjs = yinzhengjs;
        }

        public List<String> getTongyi() {
            return tongyi;
        }

        public void setTongyi(List<String> tongyi) {
            this.tongyi = tongyi;
        }

        public List<String> getFanyi() {
            return fanyi;
        }

        public void setFanyi(List<String> fanyi) {
            this.fanyi = fanyi;
        }
    }
}
