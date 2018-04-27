package com.test.jvm.stream;

/**
 * 计算字符串中数字个数
 *
 * @author liangyq 2018/3/14
 */
public class NumberCounter {

    private int num;
    private int sum;
    /**
     * 是否当前是个完整的数字
     */
    private boolean isWholeNum;

    public NumberCounter(int num, int sum, boolean isWholeNum) {
        this.num = num;
        this.sum = sum;
        this.isWholeNum = isWholeNum;
    }

    public NumberCounter accumulate(Character c) {
        if (Character.isDigit(c)) {
            return isWholeNum ?
                    new NumberCounter(Integer.parseInt("" + c), sum + num, false) :
                    new NumberCounter(Integer.parseInt("" + num + c), sum, false);
        } else {
            return new NumberCounter(0, sum + num, true);
        }
    }

    public NumberCounter combine(NumberCounter numCounter) {
        return new NumberCounter(numCounter.num, this.getSum() + numCounter.getSum(),
                numCounter.isWholeNum);
    }

    public int getSum() {
        return sum + num;
    }
}
