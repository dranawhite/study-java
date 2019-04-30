package com.study.hadoop.order;

import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Comparator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dranawhite
 * @version : OrderBean.java, v 0.1 2019-04-29 17:13 dranawhite Exp $$
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderBean implements WritableComparable<OrderBean> {

    private String orderId;

    private double amount;

    @Override
    public int compareTo(OrderBean orderBean) {
        return Comparator.comparing(OrderBean::getOrderId).thenComparingDouble(OrderBean::getAmount).compare(this,
                orderBean);
    }

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(orderId);
        out.writeDouble(amount);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        orderId = in.readUTF();
        amount = in.readDouble();
    }

}
