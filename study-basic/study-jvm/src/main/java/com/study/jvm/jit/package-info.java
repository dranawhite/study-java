/**
 * JIT编译之后的代码放在CodeCache中，CodeCache的大小也是有限的；
 * 如果CompileThreshold设置的太低，JIT会将一大堆执行不那么频繁的代码进行编译，并放入CodeCache，导致之后真正执行频繁的代码没有足够的空间存放；
 * 热点代码的编译过程是有成本的，如果逻辑复杂，编程成本更高；
 * <pre>
 *     -Xint                        强制运行解释模式
 *     -Xcomp                       强制运行编译模式
 *     -XX:-TieredCompilation       关闭分层编译(C1和C2编译器同时运行)
 * </pre>
 *
 * @author dranawhite
 * @version [V1.0, 2018/2/11]
 */

package com.study.jvm.jit;