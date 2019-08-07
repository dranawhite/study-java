/**
 * <pre>
 * 六大设计原则：
 * 1）单一职责原则(SRP):只有一个原因能引起类或方法的改变；即一个类或者方法只应该做一件事；
 *    实践：类的职责划分在业务逻辑上保持单一，从而能够使类得到复用
 * 2）里氏替换原则(LSP):能使用父类的地方，必然能够使用子类，反之则不成立；既子类必须完整的实现父类的方法，如果子类不能完整的实现父类的方法
 * 或者父类的某些方法在子类中发生了畸变，则建议断开父子继承关系，采用依赖、聚集、组合等关系代替继承；
 * 3）依赖倒置原则(DIP):
 *      高层模块不应该依赖于底层模块，两者都应该依赖于抽象；
 *      抽象不应该依赖于细节：抽象类不应该依赖于具体的实现类
 *      细节应该依赖于抽象；
 * 4）接口隔离原则(ISP)：类间的依赖关系应该建立在最小的接口上，既接口应该尽量的小，一个接口只服务于一个子模块或者业务逻辑
 * 5）迪米特法则(LOD)：一个类应该尽可能少的与其它实体相互作用
 *    实践：引入一个合理的第三者降低现有对象之间的耦合度
 * 6）开闭原则(OCP)：对扩展开放，对修改关闭；即软件尽量在不修改原有代码的基础上进行扩展
 *    实践：需求在变化时，重新定义新的实现类而不是修改接口或者抽象方法，从而达到尽量减少代码修改的目的
 *
 * SRP是关注业务原则；ISP是关注接口的清洁层面；
 * </pre>
 *
 * @author dranawhite 2019/08/07
 */
package com.dranawhite.study.pattern;