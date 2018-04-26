package com.assignment.bhumit.bhumitassignment;

import java.io.Serializable;

/**
 * Created by Bhumit on 24-Apr-17.
 */

public class Questions implements Serializable {
    String que_text,op1,op2,op3,op4,cop;

    public String getQue_text() {
        return que_text;
    }

    public void setQue_text(String que_text) {
        this.que_text = que_text;
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOp3() {
        return op3;
    }

    public void setOp3(String op3) {
        this.op3 = op3;
    }

    public String getOp4() {
        return op4;
    }

    public void setOp4(String op4) {
        this.op4 = op4;
    }

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    Questions(String que_text, String op1, String op2, String op3, String op4, String cop){
        this.que_text = que_text;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.cop = cop;

    }
}
