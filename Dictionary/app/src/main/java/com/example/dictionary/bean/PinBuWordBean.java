package com.example.dictionary.bean;

import java.util.List;

//拼音查询，部首查询，右侧的GridView对应的数据源
public class PinBuWordBean {

    /**
     * reason : 返回成功
     * result : {"list":[{"id":"fdc204330c4eb8fa","zi":"艹","py":"ao","wubi":"aghh","pinyin":"ǎo","bushou":"艹","bihua":"3"},{"id":"11d910199a81a004","zi":"艺","py":"yi","wubi":"anb","pinyin":"yì","bushou":"艹","bihua":"4"},{"id":"3c54472970e0cbfd","zi":"艾","py":"ai,yi","wubi":"aqu","pinyin":"ài,yì","bushou":"艹","bihua":"5"},{"id":"9c429fcfae78072b","zi":"艽","py":"jiao","wubi":"avb","pinyin":"jiāo","bushou":"艹","bihua":"5"},{"id":"fb75ecd5cfbde93a","zi":"节","py":"jie","wubi":"abj","pinyin":"jié,jiē","bushou":"艹","bihua":"5"},{"id":"c176282b0798a35a","zi":"艻","py":"le","wubi":"alb","pinyin":"lè","bushou":"艹","bihua":"5"},{"id":"20f7f261ded3ecb3","zi":"艿","py":"nai,reng","wubi":"aeb","pinyin":"nǎi,rèng","bushou":"艹","bihua":"5"},{"id":"1504b68337a3da14","zi":"艼","py":"ding","wubi":"asj","pinyin":"dǐng","bushou":"艹","bihua":"5"},{"id":"b44eb225ab1010ae","zi":"芁","py":"qiu","wubi":"amb","pinyin":"qiú","bushou":"艹","bihua":"5"},{"id":"d59c14f496d7b92c","zi":"芀","py":"tiao","wubi":"avb","pinyin":"tiáo","bushou":"艹","bihua":"5"}],"page":1,"pagesize":10,"totalpage":98,"totalcount":979}
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
         * list : [{"id":"fdc204330c4eb8fa","zi":"艹","py":"ao","wubi":"aghh","pinyin":"ǎo","bushou":"艹","bihua":"3"},{"id":"11d910199a81a004","zi":"艺","py":"yi","wubi":"anb","pinyin":"yì","bushou":"艹","bihua":"4"},{"id":"3c54472970e0cbfd","zi":"艾","py":"ai,yi","wubi":"aqu","pinyin":"ài,yì","bushou":"艹","bihua":"5"},{"id":"9c429fcfae78072b","zi":"艽","py":"jiao","wubi":"avb","pinyin":"jiāo","bushou":"艹","bihua":"5"},{"id":"fb75ecd5cfbde93a","zi":"节","py":"jie","wubi":"abj","pinyin":"jié,jiē","bushou":"艹","bihua":"5"},{"id":"c176282b0798a35a","zi":"艻","py":"le","wubi":"alb","pinyin":"lè","bushou":"艹","bihua":"5"},{"id":"20f7f261ded3ecb3","zi":"艿","py":"nai,reng","wubi":"aeb","pinyin":"nǎi,rèng","bushou":"艹","bihua":"5"},{"id":"1504b68337a3da14","zi":"艼","py":"ding","wubi":"asj","pinyin":"dǐng","bushou":"艹","bihua":"5"},{"id":"b44eb225ab1010ae","zi":"芁","py":"qiu","wubi":"amb","pinyin":"qiú","bushou":"艹","bihua":"5"},{"id":"d59c14f496d7b92c","zi":"芀","py":"tiao","wubi":"avb","pinyin":"tiáo","bushou":"艹","bihua":"5"}]
         * page : 1
         * pagesize : 10
         * totalpage : 98
         * totalcount : 979
         */

        private int page;
        private int pagesize;
        private int totalpage;
        private int totalcount;
        private List<ListBean> list;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getTotalpage() {
            return totalpage;
        }

        public void setTotalpage(int totalpage) {
            this.totalpage = totalpage;
        }

        public int getTotalcount() {
            return totalcount;
        }

        public void setTotalcount(int totalcount) {
            this.totalcount = totalcount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : fdc204330c4eb8fa
             * zi : 艹
             * py : ao
             * wubi : aghh
             * pinyin : ǎo
             * bushou : 艹
             * bihua : 3
             */

            private String id;
            private String zi;
            private String py;
            private String wubi;
            private String pinyin;
            private String bushou;
            private String bihua;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getZi() {
                return zi;
            }

            public void setZi(String zi) {
                this.zi = zi;
            }

            public String getPy() {
                return py;
            }

            public void setPy(String py) {
                this.py = py;
            }

            public String getWubi() {
                return wubi;
            }

            public void setWubi(String wubi) {
                this.wubi = wubi;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public String getBushou() {
                return bushou;
            }

            public void setBushou(String bushou) {
                this.bushou = bushou;
            }

            public String getBihua() {
                return bihua;
            }

            public void setBihua(String bihua) {
                this.bihua = bihua;
            }
        }
    }
}
