package com.study.jvm.gc;

/**
 * 逃逸分析
 * <pre>
 *     逃逸分析后的优化措施：
 *     1)栈上分配
 *     2)同步消除
 *     3)标量替换
 * </pre>
 *
 * <pre>
 *     -server
 *     -verbose:gc
 *     -XX:+DoEscapeAnalysis逃逸分析开启项
 * </pre>
 * <pre>
 * -XX:-DoEscapeAnalysis关闭逃逸分析后
 * [GC (Allocation Failure)   32768K->2597K(123904K), 0.0026410 secs]
 * [GC (Allocation Failure)   35365K->1926K(123904K), 0.0017264 secs]
 * [GC (Allocation Failure)   34694K->1912K(123904K), 0.0017335 secs]
 * [GC (Allocation Failure)   34680K->1927K(156672K), 0.0017327 secs]
 * [GC (Allocation Failure)   67463K->1894K(156672K), 0.0017549 secs]
 * [GC (Allocation Failure)   67430K->1862K(219136K), 0.0014278 secs]
 * [GC (Allocation Failure)  132934K->1800K(219648K), 0.0023332 secs]
 * [GC (Allocation Failure)  132872K->1800K(350720K), 0.0006313 secs]
 * [GC (Allocation Failure)  263432K->1800K(351232K), 0.0011919 secs]
 * [GC (Allocation Failure)  263432K->1800K(508416K), 0.0004828 secs]
 * [GC (Allocation Failure)  420616K->2224K(508416K), 0.0016589 secs]
 * [GC (Allocation Failure)  421040K->2172K(759808K), 0.0008652 secs]
 * [GC (Allocation Failure)  672380K->2172K(759808K), 0.0006230 secs]
 * [GC (Allocation Failure)  672380K->2172K(764416K), 0.0004994 secs]
 * [GC (Allocation Failure)  678012K->2172K(764928K), 0.0005559 secs]
 * [GC (Allocation Failure)  678012K->2172K(765952K), 0.0004128 secs]
 * [GC (Allocation Failure)  679036K->2172K(731136K), 0.0008514 secs]
 * [GC (Allocation Failure)  646780K->2172K(700928K), 0.0017339 secs]
 * [GC (Allocation Failure)  616572K->2172K(674816K), 0.0022740 secs]
 * [GC (Allocation Failure)  587900K->2172K(644608K), 0.0007613 secs]
 * [GC (Allocation Failure)  560252K->2172K(620544K), 0.0007455 secs]
 * [GC (Allocation Failure)  534140K->2172K(593920K), 0.0009719 secs]
 * [GC (Allocation Failure)  509564K->2172K(572416K), 0.0004646 secs]
 * [GC (Allocation Failure)  486012K->2172K(547840K), 0.0006846 secs]
 * [GC (Allocation Failure)  463484K->2172K(527872K), 0.0005665 secs]
 * [GC (Allocation Failure)  441980K->2172K(506368K), 0.0006384 secs]
 * [GC (Allocation Failure)  422012K->2172K(488448K), 0.0006590 secs]
 * [GC (Allocation Failure)  402556K->2172K(468480K), 0.0010074 secs]
 * [GC (Allocation Failure)  384124K->2172K(452096K), 0.0007147 secs]
 * [GC (Allocation Failure)  366716K->2172K(434688K), 0.0006108 secs]
 * [GC (Allocation Failure)  350332K->2172K(419840K), 0.0005108 secs]
 * [GC (Allocation Failure)  334460K->2172K(403968K), 0.0014973 secs]
 * [GC (Allocation Failure)  319612K->2172K(390656K), 0.0006783 secs]
 * [GC (Allocation Failure)  305276K->2172K(376320K), 0.0007522 secs]
 * [GC (Allocation Failure)  291964K->2172K(364032K), 0.0006594 secs]
 * [GC (Allocation Failure)  279164K->2172K(351232K), 0.0007396 secs]
 * [GC (Allocation Failure)  266876K->2172K(339968K), 0.0005645 secs]
 * [GC (Allocation Failure)  255100K->2172K(328704K), 0.0004231 secs]
 * [GC (Allocation Failure)  244348K->2172K(390144K), 0.0009474 secs]
 * [GC (Allocation Failure)  305276K->2172K(465408K), 0.0008624 secs]
 * [GC (Allocation Failure)  381052K->2172K(549376K), 0.0008715 secs]
 * [GC (Allocation Failure)  464508K->2172K(650752K), 0.0007289 secs]
 * [GC (Allocation Failure)  566396K->2172K(624640K), 0.0007775 secs]
 * [GC (Allocation Failure)  539772K->2172K(599040K), 0.0006752 secs]
 * Cost Time: 4569062321ns
 * </pre>
 * <pre>
 * -XX:+DoEscapeAnalysis开启逃逸分析
 * Cost Time:   79662617ns
 * </pre>
 *
 * @author dranawhite
 * @version $Id: EscapeAnalysisPro.java, v 0.1 2019-02-28 11:38 dranawhite Exp $$
 */
public class EscapeAnalysisPro {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1024 * 1024 * 1024; i++) {
            Foo foo = new Foo();
        }
        long endTime = System.nanoTime();
        System.out.println("Cost Time: " + (endTime - startTime));
    }

    static class Foo {

        private static int counter = 0;

        private int x;

        public Foo() {
            x = counter++;
        }
    }
}