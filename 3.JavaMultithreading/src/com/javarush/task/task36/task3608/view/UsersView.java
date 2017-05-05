package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by Андрей on 28.04.2017.
 */
public class UsersView implements View {
    private Controller controller;



    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
            for(User user : modelData.getUsers()) {
                System.out.println("\t" + user.toString());
            }
        } else {
            System.out.println("All users:");
            for(User user : modelData.getUsers()) {
                System.out.println("\t" + user.toString());
            }
        }


        for(int i = 0; i<51; i++) {
            System.out.print("=");
        }
        System.out.println();


    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }


    public void fireEventShowAllUsers() {
        controller.onShowAllUsers();
    }


    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }


    public void fireEventOpenUserEditForm(long id) {
        controller.onOpenUserEditForm(id);
    }
}
