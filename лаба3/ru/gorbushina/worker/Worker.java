package ru.gorbushina.worker;

import java.util.List;
import java.util.ArrayList;

public class Worker {
    private String name;
    private Department department;

    public Worker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
// это для задания 3
    public List<Worker> getDepartmentWorkers() {
        if (department != null) {
            return department.getWorkers();
        } else {
            return new ArrayList<>(); // Если у ru.gorbushina.worker.Worker нет отдела, возвращаем пустой список
        }
    }

    @Override
    public String toString() {
        if (department != null && department.getHead() == this) {
            return name + " начальник отдела " + department.getName();
        } else if (department != null) {
            return name + " работает в отделе " + department.getName() + ", начальник которого " + department.getHead().getName();
        } else {
            return name; // Если у ru.gorbushina.worker.Worker нет отдела, просто выводим имя
        }
    }
}

class Department {
    private String name;
    private Worker head;
    private List<Worker> workers = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Worker getHead() {
        return head;
    }

    public void setHead(Worker head) {
        this.head = head;
    }
    // это для задания 3
    public void addWorker(Worker worker) {
         workers.add(worker);
    }
    public List<Worker> getWorkers() {
        return workers;
    }
}