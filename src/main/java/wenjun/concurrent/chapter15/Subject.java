package wenjun.concurrent.chapter15;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observerList = new ArrayList<>();

    private int state;

    public void setState(int state) {
        if (state == this.state) {
            return;
        }

        this.state = state;
        notifyAllObserver();
    }

    public int getState() {
        return this.state;
    }


    public void attach(Observer observer) {
        observerList.add(observer);
    }

    private void notifyAllObserver() {
        observerList.forEach(Observer::update);
    }
}
