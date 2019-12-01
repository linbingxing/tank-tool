package org.tank.core.tool.utils;

import org.springframework.util.Assert;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
  * @description 随机数工具类
  * @author lbx
  * @date 2019/11/30 15:57
  * @version 1.0.0
 **/
public class RandomUtil {

    private static final String S_INT = "0123456789";
    private static final String S_STR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String S_ALL = S_INT + S_STR;

    /**
     * 生成uuid
     *
     * @return UUID
     */
    public static String randomUUID() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new UUID(random.nextLong(), random.nextLong()).toString().replace(StringPool.DASH, StringPool.EMPTY);
    }

    /**
     * 随机数生成
     *
     * @param count 字符长度
     * @return 随机数
     */
    public static String random(int count) {
        return RandomUtil.random(count, RandomType.ALL);
    }

    /**
     * 随机数生成
     *
     * @param count      字符长度
     * @param randomType 随机数类别
     * @return 随机数
     */
    public static String random(int count, RandomType randomType) {
        if (count == 0) {
            return "";
        }
        Assert.isTrue(count > 0, "Requested random string length " + count + " is less than 0.");
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            if (RandomType.INT == randomType) {
                buffer[i] = S_INT.charAt(random.nextInt(S_INT.length()));
            } else if (RandomType.STRING == randomType) {
                buffer[i] = S_STR.charAt(random.nextInt(S_STR.length()));
            } else {
                buffer[i] = S_ALL.charAt(random.nextInt(S_ALL.length()));
            }
        }
        return new String(buffer);
    }

    /**
     * @功能描述：获取指定范围的随机整数
     * @创建时间 : 2017年12月23日下午3:32:28
     * @param min
     * @param max
     * @return Integer
     */
    public static Integer randInt(int min, int max) {
        Random random = new Random();
        int result = random.nextInt(max)%(max-min+1) + min;
        return result;
    }


}
