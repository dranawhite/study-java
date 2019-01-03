package com.study.jvm.memory;

/**
 * JDK对内存填充的优化
 *
 * @author dranawhite 2017/10/23
 * @version 1.0
 */
public class Padding extends LeftPadding {
    private long value = 0;
}

class LeftPadding {
    private long l1, l2, l3, l4, l5, l6, l7;
}

class RightPadding extends Padding {
    private long l8, l9, l10, l11, l12, l13, l14, l15;
}


