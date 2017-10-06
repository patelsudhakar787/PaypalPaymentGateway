package com.example.sudhakar.amled.pojo;

/**
 * Created by sudhakar on 5/17/17.
 */

public class CalCost {
    int qty;
    float materialcost;
    float labourcost;
    float qualitycheckcost;
    float discount;

    public CalCost(int qty, float materialcost, float labourcost, float qualitycheckcost, float discount) {
        this.qty = qty;
        this.materialcost = materialcost;
        this.labourcost = labourcost;
        this.qualitycheckcost = qualitycheckcost;
        this.discount = discount;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public float getMaterialcost() {
        return materialcost;
    }

    public void setMaterialcost(float materialcost) {
        this.materialcost = materialcost;
    }

    public float getLabourcost() {
        return labourcost;
    }

    public void setLabourcost(float labourcost) {
        this.labourcost = labourcost;
    }

    public float getQualitycheckcost() {
        return qualitycheckcost;
    }

    public void setQualitycheckcost(float qualitycheckcost) {
        this.qualitycheckcost = qualitycheckcost;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "CalCost{" +
                "qty=" + qty +
                ", materialcost=" + materialcost +
                ", labourcost=" + labourcost +
                ", qualitycheckcost=" + qualitycheckcost +
                ", discount=" + discount +
                '}';
    }
}
