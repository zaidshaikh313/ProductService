package com.algoDomain.dto;

public class Charges {

    private float gst;
    private float delivery;

    public Charges(float gst, float delivery) {
        this.gst = gst;
        this.delivery = delivery;
    }

    public float getGst() {
        return gst;
    }

    public void setGst(float gst) {
        this.gst = gst;
    }

    public float getDelivery() {
        return delivery;
    }

    public void setDelivery(float delivery) {
        this.delivery = delivery;
    }
}
