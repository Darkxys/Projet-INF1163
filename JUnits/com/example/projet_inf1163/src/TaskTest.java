package com.example.projet_inf1163.src;

import com.example.projet_inf1163.ViewTasksController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TaskTest {
    @Test
    public void showNextRenew(){
        ViewTasksController tasks = new ViewTasksController();
        ArrayList<Bail> arr = tasks.generateNextRenew();

        Assertions.assertEquals(arr.size(), 1);
    }
    @Test
    public void showFuturs(){
        ViewTasksController tasks = new ViewTasksController();
        ArrayList<Bail> arr = tasks.generateFuturs();

        Assertions.assertEquals(arr.size(), 1);
    }
    @Test
    public void showModif(){
        ViewTasksController tasks = new ViewTasksController();
        ArrayList<Bail> arr = tasks.generateModif();

        Assertions.assertEquals(arr.size(), 2);
    }
}
