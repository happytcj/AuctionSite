package org.gatech.models;

/**
 * Created by Steph on 2/25/2018.
 */
public class AdminUser extends User {
    private String position;

    @Override
    public String getPosition() {
        return position;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }
}
