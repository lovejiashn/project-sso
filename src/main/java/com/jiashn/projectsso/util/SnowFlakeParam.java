package com.jiashn.projectsso.util;

/**
 * @Author: jiangjs
 * @Description:
 * @Date: 2021/12/2 11:26
 **/
public class SnowFlakeParam {

    /**
     * 起始时间戳
     */
    public final static long START_STAMP = 1638414671000L;
    /**
     *  序列号占用的位数
     */
    public final static long SERIALNUMBER_BIT = 12;
    /**
     * 机器标识占用位数
     */
    public final static long MACHINE_BIT = 5;
    /**
     * 数据中心占用位数
     */
    public final static long DATACENTER_BIT = 5;
    /**
     * 设置每部分最大长度
     */
    public final static long MAX_DATACENTER_NUM = ~(-1L << DATACENTER_BIT);
    public final static long MAX_SERIALNUMBER_NUM = ~(-1L << SERIALNUMBER_BIT);
    public final static long MAX_MACHINE_NUM = ~(-1L << MACHINE_BIT);
    /**
     * 每部分向左的位移数
     */
    public final static long MACHINE_LEFT = SERIALNUMBER_BIT;
    public final static long DATACENTER_LEFT = SERIALNUMBER_BIT + MACHINE_BIT;
    public final static long TIMESTMP_LEFT = DATACENTER_LEFT + DATACENTER_BIT;
}