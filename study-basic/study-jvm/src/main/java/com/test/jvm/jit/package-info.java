/**
 * JIT编译之后的代码放在CodeCache中，CodeCache的大小也是有限的；
 * 如果CompileThreshold设置的太低，JIT会将一大堆执行不那么频繁的代码进行编译，并放入CodeCache，导致之后真正执行频繁的代码没有足够的空间存放；
 * 热点代码的编译过程是有成本的，如果逻辑复杂，编程成本更高；
 *
 * @author liangyuquan
 * @version [V1.0, 2018/2/11]
 */

package com.test.jvm.jit;