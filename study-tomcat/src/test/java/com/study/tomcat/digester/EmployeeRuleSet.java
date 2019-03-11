package com.study.tomcat.digester;

import org.apache.commons.digester.Digester;
import org.apache.commons.digester.RuleSetBase;

/**
 *
 * @author dranawhite
 * @version $Id: EmployeeRuleSet.java, v 0.1 2019-03-09 16:33 dranawhite Exp $$
 */
public class EmployeeRuleSet extends RuleSetBase {

    @Override
    public void addRuleInstances(Digester digester) {
        digester.addObjectCreate("employee", "com.study.tomcat.digester.Employee");
        digester.addSetProperties("employee");
        digester.addObjectCreate("employee/office", "com.study.tomcat.digester.Office");
        digester.addSetProperties("employee/office");
        digester.addSetNext("employee/office", "addOffice");
        digester.addObjectCreate("employee/office/address", "com.study.tomcat.digester.Address");
        digester.addSetProperties("employee/office/address");
        digester.addSetNext("employee/office/address", "setAddress");
    }




























}
