package com.jiashn.projectsso.util;

/**
 * @Author: jiangjs
 * @Description: 雪花算法
 *         第一个部分，是 1 个 bit：0，这个是无意义的。
 *         第二个部分是 41 个 bit：表示的是时间戳。
 *         第三个部分是 5 个 bit：表示的是机房 id，10001。
 *         第四个部分是 5 个 bit：表示的是机器 id，11001。
 *         第五个部分是 12 个 bit：表示的序号，就是某个机房某台机器上这一毫秒内同时生成的 id 的序号，000000000000。
 * @Date: 2021/12/2 11:05
 **/
public class IdWorker {
    /**
     * 数据中心
     */
    private long datacenterId;
    /**
     * 机器标识
     */
    private long machineId;
    /**
     * 序列号
     */
    private long sequence =0L;
    /**
     * 上一次时间戳
     */
    private long lastStamp =1L;

    public IdWorker(long datacenterId,long machineId){
        if (datacenterId > SnowFlakeParam.MAX_DATACENTER_NUM || datacenterId < 0){
            throw new IllegalArgumentException("生成id失败");
        }
        if (machineId > SnowFlakeParam.MAX_MACHINE_NUM || machineId < 0){
            throw new IllegalArgumentException("生成id失败");
        }
        this.datacenterId = datacenterId;
        this.machineId = machineId;
    }

    public synchronized long createIdWorker(){
        long currStamp = System.currentTimeMillis();
        if (currStamp < lastStamp){
            throw new IllegalArgumentException("生成id失败");
        }
        if (currStamp == lastStamp){
            sequence = (sequence + 1) & SnowFlakeParam.MAX_SERIALNUMBER_NUM;
            if (sequence == 0L){
                currStamp = getNextMill();
            }
        } else {
            sequence = 0L;
        }
        lastStamp = currStamp;
        //时间戳部分
        return (currStamp - SnowFlakeParam.START_STAMP) << SnowFlakeParam.TIMESTMP_LEFT
                //数据中心位置
                | datacenterId << SnowFlakeParam.DATACENTER_LEFT
                //机器标识部分
                | machineId << SnowFlakeParam.MACHINE_LEFT
                //序列号部分
                | sequence;
    }

    private long getNextMill() {
        long mill = System.currentTimeMillis();
        while (mill <= lastStamp) {
            mill = System.currentTimeMillis();
        }
        return mill;
    }

}